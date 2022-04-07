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
import com.repackage.bi5;
import com.repackage.dr4;
import com.repackage.fr4;
import com.repackage.i35;
import com.repackage.or4;
import com.repackage.yh5;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.ForumToolPerm;
/* loaded from: classes7.dex */
public class qz7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q = 0;
    public static int R = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public fo A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public st4 J;
    public lk8 K;
    public boolean L;
    public final View.OnLongClickListener M;
    public or4.e N;
    public boolean O;
    public final fr4.c P;
    public AbsVideoPbFragment a;
    public mr4 b;
    public or4 c;
    public mr4 d;
    public dr4 e;
    public Dialog f;
    public Dialog g;
    public hr4 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public mr4 q;
    public yt4 r;
    public fr4 s;
    public AlertDialog t;
    public kv7 u;
    public yh5 v;
    public bi5 w;
    public xx7 x;
    public PbFragment.d3 y;
    public dw7 z;

    /* loaded from: classes7.dex */
    public class a implements fr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;

        public a(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz7Var;
        }

        @Override // com.repackage.fr4.c
        public void a(fr4 fr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fr4Var, i, view2) == null) {
                if (fr4Var != null) {
                    fr4Var.e();
                }
                if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                    } else {
                        i35.a aVar = new i35.a();
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
                        qz7 qz7Var = this.a;
                        qz7Var.z = new dw7(qz7Var.a.getPageContext());
                    }
                    this.a.z.b(this.a.B, this.a.A.n());
                }
                this.a.A = null;
                this.a.B = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements or4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ qz7 e;

        public a0(qz7 qz7Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = qz7Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.repackage.or4.e
        public void onItemClick(or4 or4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, or4Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.g0(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e59)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e57), ((Integer) this.a.get(R.id.obfuscated_res_0x7f091e74)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f091e58)).booleanValue());
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

    /* loaded from: classes7.dex */
    public class b implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;

        public b(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz7Var;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.a.a.H2(dr4Var, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;

        public b0(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz7Var;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                TiebaStatic.log("c10025");
                dr4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ qz7 c;

        public d(qz7 qz7Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qz7Var;
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
                if (!mi.A()) {
                    oi.M(this.c.a.x(), R.string.obfuscated_res_0x7f0f0c18);
                } else {
                    this.c.a.G2(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public e(qz7 qz7Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, alertDialog};
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

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ qz7 c;

        public f(qz7 qz7Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qz7Var;
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
                if (!mi.A()) {
                    oi.M(this.c.a.x(), R.string.obfuscated_res_0x7f0f0c18);
                } else {
                    this.c.a.G2(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public g(qz7 qz7Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, alertDialog};
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

    /* loaded from: classes7.dex */
    public class h implements yh5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr4 a;
        public final /* synthetic */ qz7 b;

        public h(qz7 qz7Var, dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, dr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz7Var;
            this.a = dr4Var;
        }

        @Override // com.repackage.yh5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.H2(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements bi5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ qz7 b;

        public i(qz7 qz7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.bi5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.G2(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements or4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ qz7 b;

        public j(qz7 qz7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz7Var;
            this.a = z;
        }

        @Override // com.repackage.or4.e
        public void onItemClick(or4 or4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, or4Var, i, view2) == null) {
                this.b.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e57), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e74)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e58)).booleanValue());
                        return;
                    case 11:
                        if (this.b.y != null) {
                            this.b.y.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f091e74), sparseArray.get(R.id.obfuscated_res_0x7f091e62), sparseArray.get(R.id.obfuscated_res_0x7f091e65), sparseArray.get(R.id.obfuscated_res_0x7f091e63), sparseArray.get(R.id.obfuscated_res_0x7f091e64)});
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

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;

        public k(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.t == null) {
                return;
            }
            rg.a(this.a.t, this.a.a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes7.dex */
    public class l implements fr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;

        public l(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz7Var;
        }

        @Override // com.repackage.fr4.c
        public void a(fr4 fr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fr4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    qz7 qz7Var = this.a;
                    qz7Var.H = qz7Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new eu7(this.a.a.w().l1(), this.a.H, "1").start();
                    fr4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    qz7 qz7Var2 = this.a;
                    qz7Var2.H = qz7Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new eu7(this.a.a.w().l1(), this.a.H, "2").start();
                    fr4Var.e();
                } else if (i == 2) {
                    qz7 qz7Var3 = this.a;
                    qz7Var3.H = qz7Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    fr4Var.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements or4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mr4 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ qz7 c;

        public m(qz7 qz7Var, mr4 mr4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, mr4Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qz7Var;
            this.a = mr4Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.w().i1() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.repackage.or4.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(or4 or4Var, int i, View view2) {
            boolean K2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, or4Var, i, view2) != null) {
                return;
            }
            this.a.dismiss();
            int i2 = 3;
            if (this.c.a.w().i1() != 1 || i != 1) {
                if (this.c.a.w().i1() == 2 && i == 0) {
                    i2 = 1;
                } else if (this.c.a.w().i1() == 3 && i != 2) {
                    i2 = 2;
                } else if (i == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091720 ? 1 : 0).param("obj_type", i2));
                if (this.c.a.w().T0().f != null && this.c.a.w().T0().f.size() > i) {
                    i = this.c.a.w().T0().f.get(i).sort_type.intValue();
                }
                K2 = this.c.a.w().K2(i);
                this.b.setTag(Integer.valueOf(this.c.a.w().h1()));
                if (K2) {
                    return;
                }
                this.c.a.s4(true);
                return;
            }
            i2 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091720 ? 1 : 0).param("obj_type", i2));
            if (this.c.a.w().T0().f != null) {
                i = this.c.a.w().T0().f.get(i).sort_type.intValue();
            }
            K2 = this.c.a.w().K2(i);
            this.b.setTag(Integer.valueOf(this.c.a.w().h1()));
            if (K2) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public n(qz7 qz7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, metaData};
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ qz7 b;

        public o(qz7 qz7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz7Var;
            this.a = metaData;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                dr4Var.dismiss();
                if (this.b.a.O2() != null) {
                    this.b.a.O2().l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.a.getPageContext().getUniqueId(), this.b.a.w().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ qz7 b;

        public q(qz7 qz7Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz7Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.b.B0();
                MessageManager.getInstance().sendMessage(this.a);
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements or4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr4.c a;
        public final /* synthetic */ qz7 b;

        public s(qz7 qz7Var, fr4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz7Var;
            this.a = cVar;
        }

        @Override // com.repackage.or4.e
        public void onItemClick(or4 or4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, or4Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;

        public t(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz7Var;
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

    /* loaded from: classes7.dex */
    public class u implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;

        public u(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz7Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) ? this.a.E(view2) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class v implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;

        public v(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.g instanceof Dialog)) {
                rg.b(this.a.g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements PbFragment.d3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;

        public w(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.d3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!mi.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c19);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.w().T0().l().getId(), this.a.a.w().T0().l().getName(), this.a.a.w().T0().O().getId(), String.valueOf(this.a.a.w().T0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements or4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;

        public x(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz7Var;
        }

        @Override // com.repackage.or4.e
        public void onItemClick(or4 or4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, or4Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.M0(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091698);
                        this.a.n0(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091697);
                        this.a.n0(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09169a);
                        AgreeView agreeView = (AgreeView) view5;
                        this.a.n0(view5);
                        if (agreeView == null || agreeView.getImgDisagree() == null) {
                            return;
                        }
                        agreeView.getImgDisagree().performClick();
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09169a);
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
                            i35.a aVar = new i35.a();
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
                            qz7 qz7Var = this.a;
                            qz7Var.z = new dw7(qz7Var.a.getPageContext());
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
                            if (this.a.a.w().T0().O() == null || this.a.a.w().T0().O().getAuthor() == null || this.a.a.w().T0().O().getAuthor().getUserId() == null || this.a.a.b3() == null) {
                                return;
                            }
                            qz7 qz7Var2 = this.a;
                            int S = qz7Var2.S(qz7Var2.a.w().T0());
                            ThreadData O = this.a.a.w().T0().O();
                            if (O.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (O.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!O.isBJHNormalThreadType()) {
                                i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.w().l1()).param("obj_locate", 2).param("obj_id", this.a.a.w().T0().O().getAuthor().getUserId()).param("obj_type", !this.a.a.b3().e()).param("obj_source", S).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!mi.z()) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c19);
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
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e68, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e51, 2);
                                this.a.B(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091e59) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e57) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e74) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e58) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e58)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e74)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e69)).booleanValue();
                            AbsVideoPbFragment absVideoPbFragment = this.a.a;
                            if (absVideoPbFragment == null || absVideoPbFragment.x() == null) {
                                return;
                            }
                            boolean isHost = this.a.a.x().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.a.t0(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.i0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e59)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e57), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.a.t0(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.a.g0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e59)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e57), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!mi.z()) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c19);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e97)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e95)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue();
                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f091e6d) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e6d)).booleanValue() : false;
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.a.g0(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e59)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091e57), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e74)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e58)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e68, 1);
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e51, 2);
                            this.a.B(sparseArray4);
                            return;
                        } else {
                            if (booleanValue6) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f091e51, 2);
                            }
                            this.a.l0(view2);
                            return;
                        }
                    case 8:
                        if (ViewHelper.checkUpIsLogin(this.a.a.getContext()) && (sparseArray = (SparseArray) view2.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e55);
                            if (postData2.q() == null) {
                                return;
                            }
                            p75 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                            if (findPageExtraByView != null) {
                                postData2.q().objSource = findPageExtraByView.a();
                            }
                            this.a.C(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        AbsVideoPbFragment absVideoPbFragment2 = this.a.a;
                        if (absVideoPbFragment2 == null || absVideoPbFragment2.w() == null || this.a.a.w().T0() == null || !ViewHelper.checkUpIsLogin(this.a.a.getContext()) || this.a.a.x() == null) {
                            return;
                        }
                        this.a.a.x().showBlockDialog(tr8.b(view2));
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ qz7 d;

        public y(qz7 qz7Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = qz7Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                if (dr4Var != null) {
                    dr4Var.dismiss();
                }
                this.d.a.I2(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e59)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e57), this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                dr4Var.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755362749, "Lcom/repackage/qz7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755362749, "Lcom/repackage/qz7;");
        }
    }

    public qz7(AbsVideoPbFragment absVideoPbFragment) {
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
        xx7 xx7Var = new xx7(this.a.getContext());
        this.x = xx7Var;
        xx7Var.b(this.a.getUniqueId());
        this.y = new w(this);
    }

    public void A0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) || metaData == null) {
            return;
        }
        dr4 dr4Var = new dr4(this.a.getActivity());
        dr4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a82));
        dr4Var.setTitleShowCenter(true);
        dr4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a83));
        dr4Var.setMessageShowCenter(true);
        dr4Var.setCancelable(false);
        dr4Var.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a84), new n(this, metaData));
        dr4Var.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a85), new o(this, metaData));
        dr4Var.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            B0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = mg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = mg.g((String) sparseArray.get(R.id.obfuscated_res_0x7f091ea6), 0L);
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
                this.r = new yt4(this.a.getPageContext());
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
            this.J = new st4();
        }
        if (this.K == null) {
            lk8 lk8Var = new lk8();
            this.K = lk8Var;
            lk8Var.a = this.a.getUniqueId();
        }
        wn4 wn4Var = new wn4();
        wn4Var.b = 5;
        wn4Var.h = 8;
        wn4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.w() != null) {
            wn4Var.f = this.a.w().S0();
        }
        wn4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                wn4Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment != null || absVideoPbFragment.w() == null || this.a.w().T0() == null) {
                    return;
                }
                this.J.b(this.a.x(), wn4Var, agreeData, this.a.w().T0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            wn4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            wn4Var.i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.a;
        if (absVideoPbFragment != null) {
        }
    }

    public final void C0(SparseArray<Object> sparseArray, int i2, ai5 ai5Var, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{sparseArray, Integer.valueOf(i2), ai5Var, userData, Boolean.valueOf(z2)}) == null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new bi5(this.a.getPageContext(), this.a.getView(), ai5Var, userData);
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
        mp4 mp4Var = new mp4();
        mp4Var.j(sparseArray2);
        this.w.E(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04a9), this.a.getString(R.string.obfuscated_res_0x7f0f04aa), this.a.getString(R.string.obfuscated_res_0x7f0f04ab), this.a.getString(R.string.obfuscated_res_0x7f0f04ac), this.a.getString(R.string.obfuscated_res_0x7f0f04ad)});
        this.w.D(mp4Var);
        this.w.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.F(new i(this, sparseArray));
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, oi.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
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
            dr4 dr4Var = new dr4(this.a.getPageContext().getPageActivity());
            dr4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b18));
            dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ccc, new b0(this));
            dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new c0(this));
            dr4Var.create(this.a.getPageContext()).show();
        }
    }

    public final boolean E(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        List<kr4> b2;
        kr4 kr4Var;
        kr4 kr4Var2;
        kr4 kr4Var3;
        kr4 kr4Var4;
        kr4 kr4Var5;
        fo foVar;
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
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e55);
            this.G = postData;
            if (postData == null || this.a.b3() == null) {
                return true;
            }
            boolean z5 = this.a.b3().e() && this.G.I() != null && this.G.I().equals(this.a.w().O0());
            boolean z6 = this.a.w().T0() != null && this.a.w().T0().g0();
            if (this.c == null) {
                or4 or4Var = new or4(this.a.getContext());
                this.c = or4Var;
                or4Var.n(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 == null || sparseArray == null) {
                return true;
            }
            boolean z7 = Y(view2) && !z6;
            boolean z8 = (!Y(view2) || (foVar = this.A) == null || foVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e6e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6e)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e58) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e58)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091e97) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e97)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091e95) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e95)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091e65) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e65) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091e6d) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6d)).booleanValue() : false;
            if (z7) {
                z4 = booleanValue7;
                z3 = booleanValue6;
                z2 = booleanValue5;
                arrayList.add(new kr4(1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f106f), this.c));
            } else {
                z2 = booleanValue5;
                z3 = booleanValue6;
                z4 = booleanValue7;
            }
            if (z8) {
                arrayList.add(new kr4(2, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1070), this.c));
            }
            if (!z7 && !z8) {
                kr4 kr4Var6 = new kr4(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f043c), this.c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091e55, this.G);
                kr4Var6.d.setTag(sparseArray3);
                arrayList.add(kr4Var6);
            }
            if (!booleanValue && !z6) {
                if (z5) {
                    kr4Var5 = new kr4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f85), this.c);
                } else {
                    kr4Var5 = new kr4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a81), this.c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091e55, this.G);
                sparseArray4.put(R.id.obfuscated_res_0x7f091e6e, Boolean.FALSE);
                kr4Var5.d.setTag(sparseArray4);
                arrayList.add(kr4Var5);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    kr4 kr4Var7 = new kr4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b19), this.c);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e6c, sparseArray.get(R.id.obfuscated_res_0x7f091e6c));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e74, sparseArray.get(R.id.obfuscated_res_0x7f091e74));
                    kr4Var7.d.setTag(sparseArray5);
                    arrayList.add(kr4Var7);
                } else {
                    if ((b0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                        kr4 kr4Var8 = new kr4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa9), this.c);
                        kr4Var8.d.setTag(str);
                        arrayList.add(kr4Var8);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e97, Boolean.TRUE);
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e74, sparseArray.get(R.id.obfuscated_res_0x7f091e74));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e62, sparseArray.get(R.id.obfuscated_res_0x7f091e62));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e64, sparseArray.get(R.id.obfuscated_res_0x7f091e64));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e65, str);
                    if (!X() && z2) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e6c, sparseArray.get(R.id.obfuscated_res_0x7f091e6c));
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
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e58, Boolean.valueOf(booleanValue2));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e69, sparseArray.get(R.id.obfuscated_res_0x7f091e69));
                        if (z4) {
                            kr4 kr4Var9 = new kr4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495), this.c);
                            kr4Var9.d.setTag(sparseArray6);
                            kr4Var4 = kr4Var9;
                            kr4Var = new kr4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02d4), this.c);
                            kr4Var.d.setTag(sparseArray6);
                            kr4Var2 = kr4Var4;
                        }
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e95, Boolean.FALSE);
                    }
                    kr4Var4 = null;
                    kr4Var = new kr4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02d4), this.c);
                    kr4Var.d.setTag(sparseArray6);
                    kr4Var2 = kr4Var4;
                } else if (z3) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e97, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091eaa, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e95, Boolean.TRUE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e74, sparseArray.get(R.id.obfuscated_res_0x7f091e74));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e58, Boolean.valueOf(booleanValue2));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e69, sparseArray.get(R.id.obfuscated_res_0x7f091e69));
                    if (this.a.w().T0().V() == 1002 && !booleanValue2) {
                        kr4Var3 = new kr4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa9), this.c);
                    } else {
                        kr4Var3 = new kr4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495), this.c);
                    }
                    kr4Var3.d.setTag(sparseArray7);
                    kr4Var2 = kr4Var3;
                    kr4Var = null;
                } else {
                    kr4Var = null;
                    kr4Var2 = null;
                }
                if (kr4Var2 != null) {
                    arrayList.add(kr4Var2);
                }
                if (kr4Var != null) {
                    arrayList.add(kr4Var);
                }
                rx7.a(arrayList, this.c, this.G, this.a.w());
            }
            if (UbsABTestHelper.isPBPlanA()) {
                b2 = rx7.c(arrayList, this.G.q(), sparseArray, this.c);
            } else {
                b2 = rx7.b(arrayList, this.G.q(), sparseArray, this.c);
            }
            rx7.k(b2, this.O);
            rx7.e(b2);
            this.c.o(rx7.f(this.G));
            if (UbsABTestHelper.isPBPlanA()) {
                this.c.k(b2, false);
            } else {
                this.c.k(b2, true);
            }
            mr4 mr4Var = new mr4(this.a.getPageContext(), this.c);
            this.b = mr4Var;
            mr4Var.m();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.a.w().l1()).param("fid", this.a.w().getForumId()).param("uid", this.a.w().T0().O().getAuthor().getUserId()).param("post_id", this.a.w().A()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f091ea6) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f091e51) instanceof Integer)) {
            mr4 mr4Var = this.b;
            if (mr4Var != null && mr4Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea4);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea6);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue()) {
                or4 or4Var = new or4(this.a.getBaseFragmentActivity());
                or4Var.n(new a0(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e51) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e51)).intValue() : -1) == 1) {
                    arrayList.add(new kr4(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0495), or4Var));
                }
                if (z2) {
                    arrayList.add(new kr4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1468), or4Var));
                } else {
                    arrayList.add(new kr4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b15), or4Var));
                }
                or4Var.j(arrayList);
                mr4 mr4Var2 = new mr4(this.a.getPageContext(), or4Var);
                this.b = mr4Var2;
                mr4Var2.m();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.a.o3();
            mr4 mr4Var = this.b;
            if (mr4Var != null) {
                mr4Var.dismiss();
            }
            this.a.p3();
            K();
        }
    }

    public void F0(fr4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, cVar, z2) == null) {
            mr4 mr4Var = this.d;
            if (mr4Var != null) {
                mr4Var.dismiss();
                this.d = null;
            }
            or4 or4Var = new or4(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.w().T0() != null && this.a.w().T0().O() != null && !this.a.w().T0().O().isBjh()) {
                arrayList.add(new kr4(0, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f106f), or4Var));
            }
            if (!z2) {
                arrayList.add(new kr4(1, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1070), or4Var));
            }
            or4Var.j(arrayList);
            or4Var.n(new s(this, cVar));
            mr4 mr4Var2 = new mr4(this.a.getPageContext(), or4Var);
            this.d = mr4Var2;
            mr4Var2.m();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.a.o3();
            mr4 mr4Var = this.b;
            if (mr4Var != null) {
                mr4Var.dismiss();
            }
            K();
        }
    }

    public void G0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            hr4 hr4Var = this.h;
            if (hr4Var != null) {
                hr4Var.d();
                this.h = null;
            }
            if (this.a.w() == null) {
                return;
            }
            ArrayList<qr4> arrayList = new ArrayList<>();
            arrayList.add(new qr4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0267), "", this.a.w().c1() == 1, Integer.toString(1)));
            arrayList.add(new qr4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b26), "", this.a.w().c1() == 2, Integer.toString(5)));
            arrayList.add(new qr4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b22), "", this.a.w().c1() == 3, Integer.toString(6)));
            arrayList.add(new qr4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b3d), "", this.a.w().c1() == 4, Integer.toString(7)));
            hr4 hr4Var2 = new hr4(this.a.getPageContext());
            hr4Var2.l(R.string.obfuscated_res_0x7f0f0dba);
            this.h = hr4Var2;
            hr4Var2.k(arrayList, onItemClickListener);
            hr4Var2.c();
            this.h.n();
        }
    }

    public void H() {
        mr4 mr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (mr4Var = this.b) == null) {
            return;
        }
        mr4Var.dismiss();
    }

    public void H0(lv7 lv7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, lv7Var) == null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new kv7(absVideoPbFragment, absVideoPbFragment.D1);
        AlertDialog create = new AlertDialog.Builder(this.a.getContext(), R.style.obfuscated_res_0x7f100104).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        rg.i(this.t, this.a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = oi.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ef);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.u());
        this.u.M(lv7Var == null ? false : lv7Var.a);
        this.u.z(lv7Var == null ? false : lv7Var.n);
        this.u.B(lv7Var == null ? false : lv7Var.e);
        this.u.G(lv7Var == null ? false : lv7Var.i);
        this.u.C(lv7Var == null ? false : lv7Var.f);
        this.u.O(lv7Var != null ? lv7Var.c : true);
        this.u.L(lv7Var == null ? false : lv7Var.k);
        this.u.D(lv7Var == null ? false : lv7Var.l, lv7Var.t);
        if (lv7Var == null) {
            this.u.I(false, false);
            this.u.H(false, false);
        } else {
            this.u.I(lv7Var.g, lv7Var.s);
            this.u.H(lv7Var.h, lv7Var.r);
        }
        boolean z2 = lv7Var == null ? false : lv7Var.q;
        boolean z3 = lv7Var == null ? false : lv7Var.o;
        boolean z4 = lv7Var == null ? false : lv7Var.d;
        boolean z5 = lv7Var == null ? false : lv7Var.b;
        boolean z6 = lv7Var == null ? false : lv7Var.p;
        boolean z7 = lv7Var == null ? false : lv7Var.j;
        boolean z8 = lv7Var == null ? false : lv7Var.m;
        this.u.E(z4, z3);
        this.u.N(z5, z2);
        this.u.K(z7, z6);
        this.u.Q(z8);
        if (lv7Var != null) {
            kv7 kv7Var = this.u;
            boolean z9 = lv7Var.u;
            kv7Var.w = z9;
            if (z9) {
                kv7Var.h().setText(R.string.obfuscated_res_0x7f0f0fa9);
                this.u.C(false);
            }
        }
        this.u.A(lv7Var != null ? lv7Var.v : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.a.w() != null && this.a.w().T0() != null && this.a.w().T0().Q() != null && this.a.w().T0().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.f().setText(R.string.obfuscated_res_0x7f0f0813);
        }
        N0();
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            pg.a().postDelayed(this.I, 100L);
        }
    }

    public final void I0(dr4 dr4Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, dr4Var, i2) == null) || (absVideoPbFragment = this.a) == null || dr4Var == null) {
            return;
        }
        if (this.v == null && absVideoPbFragment.getView() != null) {
            this.v = new yh5(this.a.getPageContext(), this.a.getView());
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
        mp4 mp4Var = new mp4();
        mp4Var.j(sparseArray);
        this.v.y(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04a9), this.a.getString(R.string.obfuscated_res_0x7f0f04aa), this.a.getString(R.string.obfuscated_res_0x7f0f04ab), this.a.getString(R.string.obfuscated_res_0x7f0f04ac), this.a.getString(R.string.obfuscated_res_0x7f0f04ad)});
        this.v.x(mp4Var);
        this.v.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.v.z(new h(this, dr4Var));
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (alertDialog = this.t) == null) {
            return;
        }
        rg.a(alertDialog, this.a.getPageContext().getPageActivity());
    }

    public void J0(View view2) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view2) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.w() == null) {
            return;
        }
        mr4 mr4Var = new mr4(this.a.getPageContext());
        if (this.a.w().T0().f == null || this.a.w().T0().f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1192), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1193)};
        } else {
            strArr = new String[this.a.w().T0().f.size()];
            for (int i2 = 0; i2 < this.a.w().T0().f.size(); i2++) {
                strArr[i2] = this.a.w().T0().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1190);
            }
        }
        mr4Var.j(null, strArr, new m(this, mr4Var, view2));
        mr4Var.m();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            dr4 dr4Var = this.e;
            if (dr4Var != null) {
                dr4Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                rg.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                rg.b(dialog2, this.a.getPageContext());
            }
            mr4 mr4Var = this.q;
            if (mr4Var != null) {
                mr4Var.dismiss();
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
            dr4 dr4Var = new dr4(this.a.getPageContext().getPageActivity());
            dr4Var.setMessage(str);
            dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0984, new p(this));
            dr4Var.create(this.a.getPageContext()).show();
        }
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.a.w() == null || this.a.w().T0() == null) {
                return null;
            }
            return this.a.w().T0().d();
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
            dr4 dr4Var = new dr4(this.a.getBaseFragmentActivity());
            if (ni.isEmpty(str)) {
                dr4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0310, str3));
            } else {
                dr4Var.setMessage(str);
            }
            dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0421, new q(this, userMuteAddAndDelCustomMessage));
            dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new r(this));
            dr4Var.create(this.a.getPageContext()).show();
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view2 = this.i;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f0907a2);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void M0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.w().l1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(rx7.m(i2))));
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public final void N0() {
        kv7 kv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (kv7Var = this.u) == null) {
            return;
        }
        kv7Var.y();
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

    public kv7 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.u : (kv7) invokeV.objValue;
    }

    public fr4 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.s : (fr4) invokeV.objValue;
    }

    public int S(yr7 yr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, yr7Var)) == null) {
            if (yr7Var == null || yr7Var.O() == null) {
                return 0;
            }
            if (yr7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (yr7Var.O().getThreadType() == 54) {
                return 2;
            }
            return yr7Var.O().getThreadType() == 40 ? 3 : 4;
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
            if (this.a.w() != null && this.a.w().T0() != null && this.a.w().T0().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.w().l1(), str);
                ThreadData O = this.a.w().T0().O();
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
        yt4 yt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (yt4Var = this.r) == null) {
            return;
        }
        yt4Var.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.s == null) {
            this.s = new fr4(this.a.getPageContext().getPageActivity());
            String[] strArr = {this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0363), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f118c), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10a1)};
            fr4 fr4Var = this.s;
            fr4Var.j(strArr, new l(this));
            fr4Var.g(fr4.b.obfuscated_res_0x7f1003a4);
            fr4Var.h(17);
            fr4Var.c(this.a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? rx7.h(this.a.w()) : invokeV.booleanValue;
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
                if ((i2 == 2 || i2 == 3 || i2 == 4) && this.a.w().T0().U() != null && (forumToolAuth = this.a.w().T0().U().getForumToolAuth()) != null) {
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
            if (this.a.w() != null && this.a.w().T0() != null) {
                return ((this.a.w().T0().V() != 0) || this.a.w().T0().O() == null || this.a.w().T0().O().getAuthor() == null || TextUtils.equals(this.a.w().T0().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
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
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e55)) == null) {
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
        if (postData.I() != null && postData.I().equals(this.a.w().O0())) {
            z2 = true;
        }
        MarkData N0 = this.a.w().N0(postData);
        if (this.a.w().T0() != null && this.a.w().T0().g0()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            PostData T2 = absVideoPbFragment.T2(absVideoPbFragment.w().T0());
            if (T2 != null) {
                N0 = this.a.w().N0(T2);
            }
        }
        if (N0 == null) {
            return;
        }
        this.a.y4();
        if (this.a.b3() != null) {
            this.a.b3().i(N0);
            if (!z2) {
                this.a.b3().a();
            } else {
                this.a.b3().d();
            }
        }
    }

    public void f0(ArrayList<dp4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01f2, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().j(this.i);
            if (this.g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f10039f);
                this.g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.obfuscated_res_0x7f090cdf);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702de);
                this.g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f090cde);
                TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907a1);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907a2);
                this.k = textView2;
                textView2.setOnClickListener(this.a.Y2());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f13a0));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    dp4 dp4Var = arrayList.get(i2);
                    if (dp4Var != null && !TextUtils.isEmpty(dp4Var.b()) && dp4Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(dp4Var.a()), dp4Var.b());
                        this.m.add(D2);
                        View view2 = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.j.addView(view2);
                        this.j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = oi.d(this.a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = oi.d(this.a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = oi.d(this.a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            rg.j(this.g, this.a.getPageContext());
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
            sparseArray.put(R.id.obfuscated_res_0x7f091e57, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e59, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e74, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            int i4 = (i3 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f048a : R.string.obfuscated_res_0x7f0f0fa6;
            int i5 = R.string.obfuscated_res_0x7f0f0429;
            if (i2 == 0) {
                if (i3 != 1002 || z2) {
                    i5 = R.string.obfuscated_res_0x7f0f048e;
                    i4 = R.string.obfuscated_res_0x7f0f048f;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f0faa;
                }
            }
            this.e = new dr4(this.a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.e.setMessageId(i4);
            } else {
                this.e.setOnlyMessageShowCenter(false);
                this.e.setMessage(str2);
            }
            this.e.setYesButtonTag(sparseArray);
            this.e.setPositiveButton(R.string.obfuscated_res_0x7f0f04dd, new b(this));
            this.e.setNegativeButton(R.string.obfuscated_res_0x7f0f04d8, new c(this));
            this.e.setCancelable(true);
            this.e.create(this.a.getPageContext());
            if (z3) {
                v0(sparseArray, i5, i4);
            } else if (z2) {
                v0(sparseArray, i5, i4);
            } else if (q0()) {
                ai5 ai5Var = new ai5(this.a.w().T0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.w().T0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.w().T0().o().has_forum_rule.intValue());
                ai5Var.i(this.a.w().T0().l().getId(), this.a.w().T0().l().getName());
                ai5Var.h(this.a.w().T0().l().getImage_url());
                ai5Var.j(this.a.w().T0().l().getUser_level());
                C0(sparseArray, i2, ai5Var, this.a.w().T0().U(), false);
            } else {
                I0(this.e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e57, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e59, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e74, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            if (z2) {
                r0(sparseArray);
            } else {
                s0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z2) {
        kr4 kr4Var;
        kr4 kr4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, sparseArray, z2) == null) {
            or4 or4Var = new or4(this.a.getContext());
            or4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02d4));
            or4Var.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091e51) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e51)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e57)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e59) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).intValue() : -1) == 0) {
                    kr4Var2 = new kr4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04a0), or4Var);
                } else {
                    kr4Var2 = new kr4(10, this.a.getString(R.string.obfuscated_res_0x7f0f0495), or4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e74, sparseArray.get(R.id.obfuscated_res_0x7f091e74));
                kr4Var2.d.setTag(sparseArray2);
                arrayList.add(kr4Var2);
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e62)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e63))) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091e62, sparseArray.get(R.id.obfuscated_res_0x7f091e62));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e64, sparseArray.get(R.id.obfuscated_res_0x7f091e64));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e74, sparseArray.get(R.id.obfuscated_res_0x7f091e74));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e65, sparseArray.get(R.id.obfuscated_res_0x7f091e65));
                kr4 kr4Var3 = new kr4(11, this.a.getString(R.string.obfuscated_res_0x7f0f063d), or4Var);
                kr4Var3.d.setTag(sparseArray3);
                arrayList.add(kr4Var3);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091e6c, sparseArray.get(R.id.obfuscated_res_0x7f091e6c));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea4, sparseArray.get(R.id.obfuscated_res_0x7f091ea4));
                if (z2) {
                    kr4Var = new kr4(12, this.a.getString(R.string.obfuscated_res_0x7f0f1468), or4Var);
                } else {
                    kr4Var = new kr4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b15), or4Var);
                }
                kr4Var.d.setTag(sparseArray4);
                arrayList.add(kr4Var);
            }
            or4Var.j(arrayList);
            mr4 mr4Var = this.q;
            if (mr4Var == null) {
                this.q = new mr4(this.a.getPageContext(), or4Var);
            } else {
                mr4Var.i(or4Var);
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
        yr7 T0;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.w() == null || this.a.w().T0() == null || (O = (T0 = this.a.w().T0()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.a.o3();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        lv7 lv7Var = new lv7();
        int V = this.a.w().T0().V();
        boolean z2 = true;
        if (V != 1 && V != 3) {
            lv7Var.g = false;
        } else {
            lv7Var.g = true;
            lv7Var.s = O.getIs_top() == 1;
        }
        if (Z(V)) {
            lv7Var.h = true;
            lv7Var.r = O.getIs_good() == 1;
        } else {
            lv7Var.h = false;
        }
        if (V == 1002 && !equals) {
            lv7Var.u = true;
        }
        lv7Var.n = y0(O.isBlocked(), T0.i0(), equals, V, O.isWorksInfo(), O.isScoreThread());
        lv7Var.e = u0(equals, T0.i0());
        lv7Var.i = z0();
        lv7Var.f = x0(equals);
        lv7Var.k = equals && T0.U() != null && T0.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            lv7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        lv7Var.t = equals;
        lv7Var.q = this.a.w().j1();
        lv7Var.b = true;
        lv7Var.a = b0(equals);
        lv7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        lv7Var.j = true;
        lv7Var.o = this.a.w().w0();
        lv7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            lv7Var.c = true;
        } else {
            lv7Var.c = false;
        }
        if (T0.g0()) {
            lv7Var.b = false;
            lv7Var.d = false;
            lv7Var.c = false;
            lv7Var.g = false;
            lv7Var.h = false;
        }
        lv7Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !T0.g0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2.T2(absVideoPbFragment2.w().T0()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.a;
            lv7Var.w = absVideoPbFragment3.T2(absVideoPbFragment3.w().T0()).Q;
        }
        if (O.isBlocked()) {
            lv7Var.n = false;
            lv7Var.g = false;
            lv7Var.h = false;
        }
        H0(lv7Var);
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
        sparseArray.put(R.id.obfuscated_res_0x7f09172e, Integer.valueOf(this.O ? 2 : 3));
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
            return (absVideoPbFragment == null || absVideoPbFragment.w().T0().l().getDeletedReasonInfo() == null || 1 != this.a.w().T0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void r0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e6b, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f115a, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036e, TBAlertConfig.OperateBtnStyle.SECONDARY);
        rr4 rr4Var = new rr4(this.a.x());
        rr4Var.v(R.string.obfuscated_res_0x7f0f0b11);
        rr4Var.l(R.string.obfuscated_res_0x7f0f0b12);
        rr4Var.n(true);
        rr4Var.r(aVar2, aVar);
        rr4Var.i(false);
        androidx.appcompat.app.AlertDialog y2 = rr4Var.y();
        aVar.a(new f(this, y2, sparseArray));
        aVar2.a(new g(this, y2));
    }

    public final void s0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048633, this, i2, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e6b, Boolean.TRUE);
        }
        ai5 ai5Var = new ai5(this.a.w().T0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.w().T0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.w().T0().o().has_forum_rule.intValue());
        ai5Var.i(this.a.w().T0().l().getId(), this.a.w().T0().l().getName());
        ai5Var.h(this.a.w().T0().l().getImage_url());
        ai5Var.j(this.a.w().T0().l().getUser_level());
        C0(sparseArray, i2, ai5Var, this.a.w().T0().U(), true);
    }

    public final void t0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            rx7.d(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final boolean u0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        vo4 vo4Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.w() == null || this.a.w().T0() == null) {
                return false;
            }
            yr7 T0 = this.a.w().T0();
            ThreadData O = T0.O();
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
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !ue6.isOn()) || this.a.w().G() || O.isWorksInfo() || O.isScoreThread() || z3) {
                return false;
            }
            if (T0.l() == null || !T0.l().isBlockBawuDelete) {
                if (T0.O() == null || !T0.O().isBlocked()) {
                    if (T0.V() != 0) {
                        return T0.V() != 3;
                    }
                    List<oq4> p2 = T0.p();
                    if (ListUtils.getCount(p2) > 0) {
                        for (oq4 oq4Var : p2) {
                            if (oq4Var != null && (vo4Var = oq4Var.g) != null && vo4Var.a && !vo4Var.c && ((i2 = vo4Var.b) == 1 || i2 == 2)) {
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
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0495, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036e, TBAlertConfig.OperateBtnStyle.SECONDARY);
        rr4 rr4Var = new rr4(this.a.x());
        rr4Var.v(i2);
        rr4Var.l(i3);
        rr4Var.n(true);
        rr4Var.r(aVar2, aVar);
        rr4Var.i(false);
        androidx.appcompat.app.AlertDialog y2 = rr4Var.y();
        aVar.a(new d(this, y2, sparseArray));
        aVar2.a(new e(this, y2));
    }

    public void w0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        PostData postData;
        kr4 kr4Var;
        kr4 kr4Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, sparseArray) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.w() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e55)) == null) {
            return;
        }
        if (this.c == null) {
            or4 or4Var = new or4(this.a.getContext());
            this.c = or4Var;
            or4Var.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = this.a.w().T0() != null && this.a.w().T0().g0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e58) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e58)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091e97) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e97)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091e95) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e95)).booleanValue() : false;
            kr4 kr4Var3 = null;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091e65) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e65) : null;
            if (postData.q() != null) {
                boolean z3 = postData.q().hasAgree;
                int r2 = postData.r();
                if (z3 && r2 == 5) {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.obfuscated_res_0x7f0f0083;
                } else {
                    absVideoPbFragment2 = this.a;
                    i2 = R.string.obfuscated_res_0x7f0f0085;
                }
                kr4 kr4Var4 = new kr4(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091e55, postData);
                kr4Var4.d.setTag(sparseArray2);
                arrayList.add(kr4Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    kr4 kr4Var5 = new kr4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b19), this.c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e6c, sparseArray.get(R.id.obfuscated_res_0x7f091e6c));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e74, sparseArray.get(R.id.obfuscated_res_0x7f091e74));
                    kr4Var5.d.setTag(sparseArray3);
                    arrayList.add(kr4Var5);
                } else {
                    if ((b0(booleanValue) && TbadkCoreApplication.isLogin()) && !z2) {
                        kr4 kr4Var6 = new kr4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0fa9), this.c);
                        kr4Var6.d.setTag(str);
                        arrayList.add(kr4Var6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e97, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e74, sparseArray.get(R.id.obfuscated_res_0x7f091e74));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e62, sparseArray.get(R.id.obfuscated_res_0x7f091e62));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e64, sparseArray.get(R.id.obfuscated_res_0x7f091e64));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e65, str);
                    if (booleanValue4) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e6c, sparseArray.get(R.id.obfuscated_res_0x7f091e6c));
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
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e58, Boolean.valueOf(booleanValue));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e69, sparseArray.get(R.id.obfuscated_res_0x7f091e69));
                        kr4 kr4Var7 = new kr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0495), this.c);
                        kr4Var7.d.setTag(sparseArray4);
                        kr4Var3 = kr4Var7;
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e95, Boolean.FALSE);
                    }
                    kr4 kr4Var8 = new kr4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02d4), this.c);
                    kr4Var8.d.setTag(sparseArray4);
                    kr4Var2 = kr4Var8;
                    kr4Var = kr4Var3;
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e97, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eaa, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e95, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e74, sparseArray.get(R.id.obfuscated_res_0x7f091e74));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e58, Boolean.valueOf(booleanValue));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e69, sparseArray.get(R.id.obfuscated_res_0x7f091e69));
                    if (this.a.w().T0().V() == 1002 && !booleanValue) {
                        kr4Var = new kr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0fa9), this.c);
                    } else {
                        kr4Var = new kr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0495), this.c);
                    }
                    kr4Var.d.setTag(sparseArray5);
                    kr4Var2 = null;
                } else {
                    kr4Var = null;
                    kr4Var2 = null;
                }
                if (kr4Var != null) {
                    arrayList.add(kr4Var);
                }
                if (kr4Var2 != null) {
                    arrayList.add(kr4Var2);
                }
                if (!booleanValue) {
                    arrayList.add(new kr4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0311), this.c));
                }
            }
            this.c.j(arrayList);
            mr4 mr4Var = new mr4(this.a.getPageContext(), this.c);
            this.b = mr4Var;
            mr4Var.m();
        }
    }

    public final boolean x0(boolean z2) {
        InterceptResult invokeZ;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048638, this, z2)) == null) {
            if (z2 || (absVideoPbFragment = this.a) == null || absVideoPbFragment.w() == null || this.a.w().T0() == null || (this.a.w().T0().l() != null && this.a.w().T0().l().isBlockBawuDelete)) {
                return false;
            }
            yr7 T0 = this.a.w().T0();
            if ((T0.O() == null || T0.O().getAuthor() == null || !T0.O().getAuthor().isForumBusinessAccount() || ue6.isOn()) && !this.a.w().G()) {
                return ((T0.O() != null && T0.O().isBlocked()) || this.a.w().T0().V() == 0 || this.a.w().T0().V() == 3) ? false : true;
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
            if (absVideoPbFragment == null || absVideoPbFragment.w() == null || !this.a.w().j1()) {
                return false;
            }
            return this.a.w().R0() == null || this.a.w().R0().c() != 0;
        }
        return invokeV.booleanValue;
    }
}
