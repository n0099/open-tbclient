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
import com.repackage.ii5;
import com.repackage.k35;
import com.repackage.li5;
import com.repackage.nq4;
import com.repackage.pq4;
import com.repackage.yq4;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.ForumToolPerm;
/* loaded from: classes6.dex */
public class ky7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q = 0;
    public static int R = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public ym A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public dt4 J;
    public jh8 K;
    public boolean L;
    public final View.OnLongClickListener M;
    public yq4.e N;
    public boolean O;
    public final pq4.c P;
    public AbsVideoPbFragment a;
    public wq4 b;
    public yq4 c;
    public wq4 d;
    public nq4 e;
    public Dialog f;
    public Dialog g;
    public rq4 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public wq4 q;
    public jt4 r;
    public pq4 s;
    public AlertDialog t;
    public gu7 u;
    public ii5 v;
    public li5 w;
    public rw7 x;
    public PbFragment.e3 y;
    public zu7 z;

    /* loaded from: classes6.dex */
    public class a implements pq4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky7 a;

        public a(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky7Var;
        }

        @Override // com.repackage.pq4.c
        public void a(pq4 pq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, pq4Var, i, view2) == null) {
                if (pq4Var != null) {
                    pq4Var.e();
                }
                if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                    } else {
                        k35.a aVar = new k35.a();
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
                        ky7 ky7Var = this.a;
                        ky7Var.z = new zu7(ky7Var.a.getPageContext());
                    }
                    this.a.z.b(this.a.B, this.a.A.n());
                }
                this.a.A = null;
                this.a.B = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements yq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ky7 e;

        public a0(ky7 ky7Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ky7Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.repackage.yq4.e
        public void W(yq4 yq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yq4Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.g0(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e4b), ((Integer) this.a.get(R.id.obfuscated_res_0x7f091e68)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f091e9d);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f091e9f);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f091e9e);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.D);
                    userMuteAddAndDelCustomMessage.setTag(this.e.D);
                    this.e.L0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f091e9b));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky7 a;

        public b(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky7Var;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                this.a.a.y3(nq4Var, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky7 a;

        public b0(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky7Var;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                TiebaStatic.log("c10025");
                nq4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ ky7 c;

        public d(ky7 ky7Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ky7Var;
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
                if (!ni.A()) {
                    pi.N(this.c.a.N(), R.string.obfuscated_res_0x7f0f0c37);
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

        public e(ky7 ky7Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, alertDialog};
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
        public final /* synthetic */ ky7 c;

        public f(ky7 ky7Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ky7Var;
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
                if (!ni.A()) {
                    pi.N(this.c.a.N(), R.string.obfuscated_res_0x7f0f0c37);
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

        public g(ky7 ky7Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, alertDialog};
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
    public class h implements ii5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nq4 a;
        public final /* synthetic */ ky7 b;

        public h(ky7 ky7Var, nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, nq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky7Var;
            this.a = nq4Var;
        }

        @Override // com.repackage.ii5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.y3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements li5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ ky7 b;

        public i(ky7 ky7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.li5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.x3(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements yq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ky7 b;

        public j(ky7 ky7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky7Var;
            this.a = z;
        }

        @Override // com.repackage.yq4.e
        public void W(yq4 yq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yq4Var, i, view2) == null) {
                this.b.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e4b), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e68)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue());
                        return;
                    case 11:
                        if (this.b.y != null) {
                            this.b.y.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f091e68), sparseArray.get(R.id.obfuscated_res_0x7f091e56), sparseArray.get(R.id.obfuscated_res_0x7f091e59), sparseArray.get(R.id.obfuscated_res_0x7f091e57), sparseArray.get(R.id.obfuscated_res_0x7f091e58)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.T(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9c), sparseArray);
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
        public final /* synthetic */ ky7 a;

        public k(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.t == null) {
                return;
            }
            sg.a(this.a.t, this.a.a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes6.dex */
    public class l implements pq4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky7 a;

        public l(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky7Var;
        }

        @Override // com.repackage.pq4.c
        public void a(pq4 pq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, pq4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    ky7 ky7Var = this.a;
                    ky7Var.H = ky7Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new at7(this.a.a.F().i2(), this.a.H, "1").start();
                    pq4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    ky7 ky7Var2 = this.a;
                    ky7Var2.H = ky7Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new at7(this.a.a.F().i2(), this.a.H, "2").start();
                    pq4Var.e();
                } else if (i == 2) {
                    ky7 ky7Var3 = this.a;
                    ky7Var3.H = ky7Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    pq4Var.e();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements yq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wq4 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ ky7 c;

        public m(ky7 ky7Var, wq4 wq4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, wq4Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ky7Var;
            this.a = wq4Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.F().f2() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.repackage.yq4.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void W(yq4 yq4Var, int i, View view2) {
            boolean H3;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, yq4Var, i, view2) != null) {
                return;
            }
            this.a.dismiss();
            int i2 = 3;
            if (this.c.a.F().f2() != 1 || i != 1) {
                if (this.c.a.F().f2() == 2 && i == 0) {
                    i2 = 1;
                } else if (this.c.a.F().f2() == 3 && i != 2) {
                    i2 = 2;
                } else if (i == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f0916f2 ? 1 : 0).param("obj_type", i2));
                if (this.c.a.F().Q1().f != null && this.c.a.F().Q1().f.size() > i) {
                    i = this.c.a.F().Q1().f.get(i).sort_type.intValue();
                }
                H3 = this.c.a.F().H3(i);
                this.b.setTag(Integer.valueOf(this.c.a.F().e2()));
                if (H3) {
                    return;
                }
                this.c.a.l5(true);
                return;
            }
            i2 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f0916f2 ? 1 : 0).param("obj_type", i2));
            if (this.c.a.F().Q1().f != null) {
                i = this.c.a.F().Q1().f.get(i).sort_type.intValue();
            }
            H3 = this.c.a.F().H3(i);
            this.b.setTag(Integer.valueOf(this.c.a.F().e2()));
            if (H3) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public n(ky7 ky7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, metaData};
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

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ ky7 b;

        public o(ky7 ky7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky7Var;
            this.a = metaData;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                nq4Var.dismiss();
                if (this.b.a.H3() != null) {
                    this.b.a.H3().l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.a.getPageContext().getUniqueId(), this.b.a.F().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ ky7 b;

        public q(ky7 ky7Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky7Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                this.b.B0();
                MessageManager.getInstance().sendMessage(this.a);
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements yq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pq4.c a;
        public final /* synthetic */ ky7 b;

        public s(ky7 ky7Var, pq4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky7Var;
            this.a = cVar;
        }

        @Override // com.repackage.yq4.e
        public void W(yq4 yq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yq4Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky7 a;

        public t(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky7Var;
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
        public final /* synthetic */ ky7 a;

        public u(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky7Var;
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
        public final /* synthetic */ ky7 a;

        public v(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.g instanceof Dialog)) {
                sg.b(this.a.g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements PbFragment.e3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky7 a;

        public w(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.e3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!ni.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.F().Q1().l().getId(), this.a.a.F().Q1().l().getName(), this.a.a.F().Q1().O().getId(), String.valueOf(this.a.a.F().Q1().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x implements yq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky7 a;

        public x(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky7Var;
        }

        @Override // com.repackage.yq4.e
        public void W(yq4 yq4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yq4Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.M0(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091668);
                        this.a.n0(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091667);
                        this.a.n0(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09166a);
                        AgreeView agreeView = (AgreeView) view5;
                        this.a.n0(view5);
                        if (agreeView == null || agreeView.getImgDisagree() == null) {
                            return;
                        }
                        agreeView.getImgDisagree().performClick();
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09166a);
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
                            k35.a aVar = new k35.a();
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
                            ky7 ky7Var = this.a;
                            ky7Var.z = new zu7(ky7Var.a.getPageContext());
                        }
                        this.a.z.b(this.a.B, this.a.A.n());
                        this.a.A = null;
                        this.a.B = null;
                        return;
                    case 3:
                        PostData postData = this.a.G;
                        if (postData != null) {
                            postData.p0();
                            this.a.G = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.a.a.checkUpIsLogin()) {
                            this.a.d0(view2);
                            if (this.a.a.F().Q1().O() == null || this.a.a.F().Q1().O().getAuthor() == null || this.a.a.F().Q1().O().getAuthor().getUserId() == null || this.a.a.U3() == null) {
                                return;
                            }
                            ky7 ky7Var2 = this.a;
                            int S = ky7Var2.S(ky7Var2.a.F().Q1());
                            ThreadData O = this.a.a.F().Q1().O();
                            if (O.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (O.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!O.isBJHNormalThreadType()) {
                                i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.F().i2()).param("obj_locate", 2).param("obj_id", this.a.a.F().Q1().O().getAuthor().getUserId()).param("obj_type", !this.a.a.U3().e()).param("obj_source", S).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!ni.z()) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
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
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e5c, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e45, 2);
                                this.a.B(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091e4d) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e4b) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e68) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e4c) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e68)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e5d)).booleanValue();
                            AbsVideoPbFragment absVideoPbFragment = this.a.a;
                            if (absVideoPbFragment == null || absVideoPbFragment.N() == null) {
                                return;
                            }
                            boolean G = this.a.a.N().G(TbadkCoreApplication.getCurrentAccount());
                            if (G) {
                                if (!booleanValue2) {
                                    this.a.t0(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.a.i0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e4b), intValue, booleanValue, null, G);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.a.t0(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.a.g0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e4b), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!ni.z()) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e8c)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e8a)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue();
                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f091e61) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e61)).booleanValue() : false;
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.a.g0(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091e4b), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e68)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e5c, 1);
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e45, 2);
                            this.a.B(sparseArray4);
                            return;
                        } else {
                            if (booleanValue6) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f091e45, 2);
                            }
                            this.a.l0(view2);
                            return;
                        }
                    case 8:
                        if (ViewHelper.checkUpIsLogin(this.a.a.getContext()) && (sparseArray = (SparseArray) view2.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e49);
                            if (postData2.q() == null) {
                                return;
                            }
                            n75 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                            if (findPageExtraByView != null) {
                                postData2.q().objSource = findPageExtraByView.a();
                            }
                            this.a.C(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        AbsVideoPbFragment absVideoPbFragment2 = this.a.a;
                        if (absVideoPbFragment2 == null || absVideoPbFragment2.F() == null || this.a.a.F().Q1() == null || !ViewHelper.checkUpIsLogin(this.a.a.getContext()) || this.a.a.N() == null) {
                            return;
                        }
                        this.a.a.N().d1(ho8.c(view2));
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ ky7 d;

        public y(ky7 ky7Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ky7Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                if (nq4Var != null) {
                    nq4Var.dismiss();
                }
                this.d.a.z3(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e4b), this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755542456, "Lcom/repackage/ky7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755542456, "Lcom/repackage/ky7;");
        }
    }

    public ky7(AbsVideoPbFragment absVideoPbFragment) {
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
        rw7 rw7Var = new rw7(this.a.getContext());
        this.x = rw7Var;
        rw7Var.b(this.a.getUniqueId());
        this.y = new w(this);
    }

    public void A0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) || metaData == null) {
            return;
        }
        nq4 nq4Var = new nq4(this.a.getActivity());
        nq4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a94));
        nq4Var.setTitleShowCenter(true);
        nq4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a95));
        nq4Var.setMessageShowCenter(true);
        nq4Var.setCancelable(false);
        nq4Var.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a96), new n(this, metaData));
        nq4Var.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a97), new o(this, metaData));
        nq4Var.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            B0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = ng.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = ng.g((String) sparseArray.get(R.id.obfuscated_res_0x7f091e9c), 0L);
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
                this.r = new jt4(this.a.getPageContext());
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
            this.J = new dt4();
        }
        if (this.K == null) {
            jh8 jh8Var = new jh8();
            this.K = jh8Var;
            jh8Var.a = this.a.getUniqueId();
        }
        en4 en4Var = new en4();
        en4Var.b = 5;
        en4Var.h = 8;
        en4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.F() != null) {
            en4Var.f = this.a.F().P1();
        }
        en4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                en4Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment != null || absVideoPbFragment.F() == null || this.a.F().Q1() == null) {
                    return;
                }
                this.J.b(this.a.N(), en4Var, agreeData, this.a.F().Q1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            en4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            en4Var.i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.a;
        if (absVideoPbFragment != null) {
        }
    }

    public final void C0(SparseArray<Object> sparseArray, int i2, ki5 ki5Var, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{sparseArray, Integer.valueOf(i2), ki5Var, userData, Boolean.valueOf(z2)}) == null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new li5(this.a.getPageContext(), this.a.getView(), ki5Var, userData);
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
        vo4 vo4Var = new vo4();
        vo4Var.j(sparseArray2);
        this.w.E(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04aa), this.a.getString(R.string.obfuscated_res_0x7f0f04ab), this.a.getString(R.string.obfuscated_res_0x7f0f04ac), this.a.getString(R.string.obfuscated_res_0x7f0f04ad), this.a.getString(R.string.obfuscated_res_0x7f0f04ae)});
        this.w.D(vo4Var);
        this.w.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.F(new i(this, sparseArray));
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, pi.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
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
            nq4 nq4Var = new nq4(this.a.getPageContext().getPageActivity());
            nq4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b32));
            nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cef, new b0(this));
            nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new c0(this));
            nq4Var.create(this.a.getPageContext()).show();
        }
    }

    public final boolean E(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        List<uq4> b2;
        uq4 uq4Var;
        uq4 uq4Var2;
        uq4 uq4Var3;
        uq4 uq4Var4;
        uq4 uq4Var5;
        ym ymVar;
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
                        if (view2.getTag(R.id.obfuscated_res_0x7f091e80) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e80) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e80);
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
                        if (view2.getTag(R.id.obfuscated_res_0x7f091e80) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e80) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e80);
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f091e80) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e80) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e80);
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
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e49);
            this.G = postData;
            if (postData == null || this.a.U3() == null) {
                return true;
            }
            boolean z5 = this.a.U3().e() && this.G.J() != null && this.G.J().equals(this.a.F().L1());
            boolean z6 = this.a.F().Q1() != null && this.a.F().Q1().g0();
            if (this.c == null) {
                yq4 yq4Var = new yq4(this.a.getContext());
                this.c = yq4Var;
                yq4Var.n(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 == null || sparseArray == null) {
                return true;
            }
            boolean z7 = Y(view2) && !z6;
            boolean z8 = (!Y(view2) || (ymVar = this.A) == null || ymVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e62) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e62)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e4c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091e8c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8c)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091e8a) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8a)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091e59) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e59) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091e61) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e61)).booleanValue() : false;
            if (z7) {
                z4 = booleanValue7;
                z3 = booleanValue6;
                z2 = booleanValue5;
                arrayList.add(new uq4(1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10a1), this.c));
            } else {
                z2 = booleanValue5;
                z3 = booleanValue6;
                z4 = booleanValue7;
            }
            if (z8) {
                arrayList.add(new uq4(2, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10a2), this.c));
            }
            if (!z7 && !z8) {
                uq4 uq4Var6 = new uq4(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f043b), this.c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091e49, this.G);
                uq4Var6.d.setTag(sparseArray3);
                arrayList.add(uq4Var6);
            }
            if (!booleanValue && !z6) {
                if (z5) {
                    uq4Var5 = new uq4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fb8), this.c);
                } else {
                    uq4Var5 = new uq4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a92), this.c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091e49, this.G);
                sparseArray4.put(R.id.obfuscated_res_0x7f091e62, Boolean.FALSE);
                uq4Var5.d.setTag(sparseArray4);
                arrayList.add(uq4Var5);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    uq4 uq4Var7 = new uq4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b33), this.c);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea0, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e60, sparseArray.get(R.id.obfuscated_res_0x7f091e60));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e9c, sparseArray.get(R.id.obfuscated_res_0x7f091e9c));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e9d, sparseArray.get(R.id.obfuscated_res_0x7f091e9d));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e9b, sparseArray.get(R.id.obfuscated_res_0x7f091e9b));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e9e, sparseArray.get(R.id.obfuscated_res_0x7f091e9e));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e9f, sparseArray.get(R.id.obfuscated_res_0x7f091e9f));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e4c, sparseArray.get(R.id.obfuscated_res_0x7f091e4c));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e4d, sparseArray.get(R.id.obfuscated_res_0x7f091e4d));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e4b, sparseArray.get(R.id.obfuscated_res_0x7f091e4b));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                    uq4Var7.d.setTag(sparseArray5);
                    arrayList.add(uq4Var7);
                } else {
                    if ((b0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                        uq4 uq4Var8 = new uq4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fdb), this.c);
                        uq4Var8.d.setTag(str);
                        arrayList.add(uq4Var8);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e8c, Boolean.TRUE);
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e59, str);
                    if (!X() && z2) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ea0, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e60, sparseArray.get(R.id.obfuscated_res_0x7f091e60));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e9c, sparseArray.get(R.id.obfuscated_res_0x7f091e9c));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e9d, sparseArray.get(R.id.obfuscated_res_0x7f091e9d));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e9b, sparseArray.get(R.id.obfuscated_res_0x7f091e9b));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e9e, sparseArray.get(R.id.obfuscated_res_0x7f091e9e));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e9f, sparseArray.get(R.id.obfuscated_res_0x7f091e9f));
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ea0, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e8a, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e4c, Boolean.valueOf(booleanValue2));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e4b, sparseArray.get(R.id.obfuscated_res_0x7f091e4b));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e4d, sparseArray.get(R.id.obfuscated_res_0x7f091e4d));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e5d, sparseArray.get(R.id.obfuscated_res_0x7f091e5d));
                        if (z4) {
                            uq4 uq4Var9 = new uq4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0496), this.c);
                            uq4Var9.d.setTag(sparseArray6);
                            uq4Var4 = uq4Var9;
                            uq4Var = new uq4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02db), this.c);
                            uq4Var.d.setTag(sparseArray6);
                            uq4Var2 = uq4Var4;
                        }
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e8a, Boolean.FALSE);
                    }
                    uq4Var4 = null;
                    uq4Var = new uq4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02db), this.c);
                    uq4Var.d.setTag(sparseArray6);
                    uq4Var2 = uq4Var4;
                } else if (z3) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e8c, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091ea0, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e8a, Boolean.TRUE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e4c, Boolean.valueOf(booleanValue2));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e4b, sparseArray.get(R.id.obfuscated_res_0x7f091e4b));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e4d, sparseArray.get(R.id.obfuscated_res_0x7f091e4d));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e5d, sparseArray.get(R.id.obfuscated_res_0x7f091e5d));
                    if (this.a.F().Q1().V() == 1002 && !booleanValue2) {
                        uq4Var3 = new uq4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fdb), this.c);
                    } else {
                        uq4Var3 = new uq4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0496), this.c);
                    }
                    uq4Var3.d.setTag(sparseArray7);
                    uq4Var2 = uq4Var3;
                    uq4Var = null;
                } else {
                    uq4Var = null;
                    uq4Var2 = null;
                }
                if (uq4Var2 != null) {
                    arrayList.add(uq4Var2);
                }
                if (uq4Var != null) {
                    arrayList.add(uq4Var);
                }
                lw7.a(arrayList, this.c, this.G, this.a.F());
            }
            if (UbsABTestHelper.isPBPlanA()) {
                b2 = lw7.c(arrayList, this.G.q(), sparseArray, this.c);
            } else {
                b2 = lw7.b(arrayList, this.G.q(), sparseArray, this.c);
            }
            lw7.k(b2, this.O);
            lw7.e(b2);
            this.c.o(lw7.f(this.G));
            if (UbsABTestHelper.isPBPlanA()) {
                this.c.k(b2, false);
            } else {
                this.c.k(b2, true);
            }
            wq4 wq4Var = new wq4(this.a.getPageContext(), this.c);
            this.b = wq4Var;
            wq4Var.m();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.a.F().i2()).param("fid", this.a.F().getForumId()).param("uid", this.a.F().Q1().O().getAuthor().getUserId()).param("post_id", this.a.F().B()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f091e9c) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f091e45) instanceof Integer)) {
            wq4 wq4Var = this.b;
            if (wq4Var != null && wq4Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9a);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9c);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue()) {
                yq4 yq4Var = new yq4(this.a.getBaseFragmentActivity());
                yq4Var.n(new a0(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e45) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e45)).intValue() : -1) == 1) {
                    arrayList.add(new uq4(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0496), yq4Var));
                }
                if (z2) {
                    arrayList.add(new uq4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14b0), yq4Var));
                } else {
                    arrayList.add(new uq4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b2f), yq4Var));
                }
                yq4Var.j(arrayList);
                wq4 wq4Var2 = new wq4(this.a.getPageContext(), yq4Var);
                this.b = wq4Var2;
                wq4Var2.m();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.a.h4();
            wq4 wq4Var = this.b;
            if (wq4Var != null) {
                wq4Var.dismiss();
            }
            this.a.i4();
            K();
        }
    }

    public void F0(pq4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, cVar, z2) == null) {
            wq4 wq4Var = this.d;
            if (wq4Var != null) {
                wq4Var.dismiss();
                this.d = null;
            }
            yq4 yq4Var = new yq4(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.F().Q1() != null && this.a.F().Q1().O() != null && !this.a.F().Q1().O().isBjh()) {
                arrayList.add(new uq4(0, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10a1), yq4Var));
            }
            if (!z2) {
                arrayList.add(new uq4(1, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10a2), yq4Var));
            }
            yq4Var.j(arrayList);
            yq4Var.n(new s(this, cVar));
            wq4 wq4Var2 = new wq4(this.a.getPageContext(), yq4Var);
            this.d = wq4Var2;
            wq4Var2.m();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.a.h4();
            wq4 wq4Var = this.b;
            if (wq4Var != null) {
                wq4Var.dismiss();
            }
            K();
        }
    }

    public void G0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            rq4 rq4Var = this.h;
            if (rq4Var != null) {
                rq4Var.d();
                this.h = null;
            }
            if (this.a.F() == null) {
                return;
            }
            ArrayList<ar4> arrayList = new ArrayList<>();
            arrayList.add(new ar4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f026a), "", this.a.F().Z1() == 1, Integer.toString(1)));
            arrayList.add(new ar4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b40), "", this.a.F().Z1() == 2, Integer.toString(5)));
            arrayList.add(new ar4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b3c), "", this.a.F().Z1() == 3, Integer.toString(6)));
            arrayList.add(new ar4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b5a), "", this.a.F().Z1() == 4, Integer.toString(7)));
            rq4 rq4Var2 = new rq4(this.a.getPageContext());
            rq4Var2.l(R.string.obfuscated_res_0x7f0f0ddd);
            this.h = rq4Var2;
            rq4Var2.k(arrayList, onItemClickListener);
            rq4Var2.c();
            this.h.n();
        }
    }

    public void H() {
        wq4 wq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (wq4Var = this.b) == null) {
            return;
        }
        wq4Var.dismiss();
    }

    public void H0(hu7 hu7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, hu7Var) == null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new gu7(absVideoPbFragment, absVideoPbFragment.D1);
        AlertDialog create = new AlertDialog.Builder(this.a.getContext(), R.style.obfuscated_res_0x7f100104).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        sg.i(this.t, this.a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = pi.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ee);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.w());
        this.u.O(hu7Var == null ? false : hu7Var.a);
        this.u.B(hu7Var == null ? false : hu7Var.n);
        this.u.D(hu7Var == null ? false : hu7Var.e);
        this.u.I(hu7Var == null ? false : hu7Var.i);
        this.u.E(hu7Var == null ? false : hu7Var.f);
        this.u.Q(hu7Var != null ? hu7Var.c : true);
        this.u.N(hu7Var == null ? false : hu7Var.k);
        this.u.F(hu7Var == null ? false : hu7Var.l, hu7Var.t);
        if (hu7Var == null) {
            this.u.L(false, false);
            this.u.J(false, false);
        } else {
            this.u.L(hu7Var.g, hu7Var.s);
            this.u.J(hu7Var.h, hu7Var.r);
        }
        boolean z2 = hu7Var == null ? false : hu7Var.q;
        boolean z3 = hu7Var == null ? false : hu7Var.o;
        boolean z4 = hu7Var == null ? false : hu7Var.d;
        boolean z5 = hu7Var == null ? false : hu7Var.b;
        boolean z6 = hu7Var == null ? false : hu7Var.p;
        boolean z7 = hu7Var == null ? false : hu7Var.j;
        boolean z8 = hu7Var == null ? false : hu7Var.m;
        this.u.G(z4, z3);
        this.u.P(z5, z2);
        this.u.M(z7, z6);
        this.u.S(z8);
        if (hu7Var != null) {
            gu7 gu7Var = this.u;
            boolean z9 = hu7Var.u;
            gu7Var.w = z9;
            if (z9) {
                gu7Var.k().setText(R.string.obfuscated_res_0x7f0f0fdb);
                this.u.E(false);
            }
        }
        this.u.C(hu7Var != null ? hu7Var.v : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.a.F() != null && this.a.F().Q1() != null && this.a.F().Q1().Q() != null && this.a.F().Q1().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.h().setText(R.string.obfuscated_res_0x7f0f081e);
        }
        N0();
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            qg.a().postDelayed(this.I, 100L);
        }
    }

    public final void I0(nq4 nq4Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, nq4Var, i2) == null) || (absVideoPbFragment = this.a) == null || nq4Var == null) {
            return;
        }
        if (this.v == null && absVideoPbFragment.getView() != null) {
            this.v = new ii5(this.a.getPageContext(), this.a.getView());
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
        vo4 vo4Var = new vo4();
        vo4Var.j(sparseArray);
        this.v.y(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04aa), this.a.getString(R.string.obfuscated_res_0x7f0f04ab), this.a.getString(R.string.obfuscated_res_0x7f0f04ac), this.a.getString(R.string.obfuscated_res_0x7f0f04ad), this.a.getString(R.string.obfuscated_res_0x7f0f04ae)});
        this.v.x(vo4Var);
        this.v.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.v.z(new h(this, nq4Var));
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (alertDialog = this.t) == null) {
            return;
        }
        sg.a(alertDialog, this.a.getPageContext().getPageActivity());
    }

    public void J0(View view2) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view2) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.F() == null) {
            return;
        }
        wq4 wq4Var = new wq4(this.a.getPageContext());
        if (this.a.F().Q1().f == null || this.a.F().Q1().f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11cd), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11ce)};
        } else {
            strArr = new String[this.a.F().Q1().f.size()];
            for (int i2 = 0; i2 < this.a.F().Q1().f.size(); i2++) {
                strArr[i2] = this.a.F().Q1().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11cb);
            }
        }
        wq4Var.j(null, strArr, new m(this, wq4Var, view2));
        wq4Var.m();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            nq4 nq4Var = this.e;
            if (nq4Var != null) {
                nq4Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                sg.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                sg.b(dialog2, this.a.getPageContext());
            }
            wq4 wq4Var = this.q;
            if (wq4Var != null) {
                wq4Var.dismiss();
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
            nq4 nq4Var = new nq4(this.a.getPageContext().getPageActivity());
            nq4Var.setMessage(str);
            nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0993, new p(this));
            nq4Var.create(this.a.getPageContext()).show();
        }
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.a.F() == null || this.a.F().Q1() == null) {
                return null;
            }
            return this.a.F().Q1().d();
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
            nq4 nq4Var = new nq4(this.a.getBaseFragmentActivity());
            if (oi.isEmpty(str)) {
                nq4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0315, str3));
            } else {
                nq4Var.setMessage(str);
            }
            nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f041f, new q(this, userMuteAddAndDelCustomMessage));
            nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new r(this));
            nq4Var.create(this.a.getPageContext()).show();
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view2 = this.i;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f09076f);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void M0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.F().i2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(lw7.m(i2))));
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public final void N0() {
        gu7 gu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (gu7Var = this.u) == null) {
            return;
        }
        gu7Var.A();
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

    public gu7 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.u : (gu7) invokeV.objValue;
    }

    public pq4 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.s : (pq4) invokeV.objValue;
    }

    public int S(rq7 rq7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, rq7Var)) == null) {
            if (rq7Var == null || rq7Var.O() == null) {
                return 0;
            }
            if (rq7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (rq7Var.O().getThreadType() == 54) {
                return 2;
            }
            return rq7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void T(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091e9d) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9d) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091e9f) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9f) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f091e9e) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9e) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f091e9a) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9a) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f091e9b) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e9b) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str4, 1, str5, this.D);
            userMuteAddAndDelCustomMessage.setTag(this.D);
            L0(z2, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            if (this.a.F() != null && this.a.F().Q1() != null && this.a.F().Q1().g0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.a.F().i2(), str);
                ThreadData O = this.a.F().Q1().O();
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
        jt4 jt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (jt4Var = this.r) == null) {
            return;
        }
        jt4Var.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.s == null) {
            this.s = new pq4(this.a.getPageContext().getPageActivity());
            String[] strArr = {this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f035b), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f11c7), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10d3)};
            pq4 pq4Var = this.s;
            pq4Var.j(strArr, new l(this));
            pq4Var.g(pq4.b.obfuscated_res_0x7f1003a4);
            pq4Var.h(17);
            pq4Var.c(this.a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? lw7.h(this.a.F()) : invokeV.booleanValue;
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
                if ((i2 == 2 || i2 == 3 || i2 == 4) && this.a.F().Q1().U() != null && (forumToolAuth = this.a.F().Q1().U().getForumToolAuth()) != null) {
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
            if (this.a.F() != null && this.a.F().Q1() != null) {
                return ((this.a.F().Q1().V() != 0) || this.a.F().Q1().O() == null || this.a.F().Q1().O().getAuthor() == null || TextUtils.equals(this.a.F().Q1().O().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
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
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e49)) == null) {
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
        if (postData.J() != null && postData.J().equals(this.a.F().L1())) {
            z2 = true;
        }
        MarkData K1 = this.a.F().K1(postData);
        if (this.a.F().Q1() != null && this.a.F().Q1().g0()) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            PostData M3 = absVideoPbFragment.M3(absVideoPbFragment.F().Q1());
            if (M3 != null) {
                K1 = this.a.F().K1(M3);
            }
        }
        if (K1 == null) {
            return;
        }
        this.a.r5();
        if (this.a.U3() != null) {
            this.a.U3().i(K1);
            if (!z2) {
                this.a.U3().a();
            } else {
                this.a.U3().d();
            }
        }
    }

    public void f0(ArrayList<lo4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e1, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().j(this.i);
            if (this.g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f10039f);
                this.g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.obfuscated_res_0x7f090c80);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702de);
                this.g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f090c7f);
                TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09076e);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09076f);
                this.k = textView2;
                textView2.setOnClickListener(this.a.R3());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f13e3));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    lo4 lo4Var = arrayList.get(i2);
                    if (lo4Var != null && !TextUtils.isEmpty(lo4Var.b()) && lo4Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(lo4Var.a()), lo4Var.b());
                        this.m.add(D2);
                        View view2 = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.j.addView(view2);
                        this.j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = pi.d(this.a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = pi.d(this.a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = pi.d(this.a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            sg.j(this.g, this.a.getPageContext());
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
            sparseArray.put(R.id.obfuscated_res_0x7f091e4b, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e4d, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e68, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e4c, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            int i4 = (i3 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f048b : R.string.obfuscated_res_0x7f0f0fd8;
            int i5 = R.string.obfuscated_res_0x7f0f0427;
            if (i2 == 0) {
                if (i3 != 1002 || z2) {
                    i5 = R.string.obfuscated_res_0x7f0f048f;
                    i4 = R.string.obfuscated_res_0x7f0f0490;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f0fdc;
                }
            }
            this.e = new nq4(this.a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.e.setMessageId(i4);
            } else {
                this.e.setOnlyMessageShowCenter(false);
                this.e.setMessage(str2);
            }
            this.e.setYesButtonTag(sparseArray);
            this.e.setPositiveButton(R.string.obfuscated_res_0x7f0f04dc, new b(this));
            this.e.setNegativeButton(R.string.obfuscated_res_0x7f0f04d7, new c(this));
            this.e.setCancelable(true);
            this.e.create(this.a.getPageContext());
            if (z3) {
                v0(sparseArray, i5, i4);
            } else if (z2) {
                v0(sparseArray, i5, i4);
            } else if (q0()) {
                ki5 ki5Var = new ki5(this.a.F().Q1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.F().Q1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.F().Q1().o().has_forum_rule.intValue());
                ki5Var.i(this.a.F().Q1().l().getId(), this.a.F().Q1().l().getName());
                ki5Var.h(this.a.F().Q1().l().getImage_url());
                ki5Var.j(this.a.F().Q1().l().getUser_level());
                C0(sparseArray, i2, ki5Var, this.a.F().Q1().U(), false);
            } else {
                I0(this.e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e4b, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e4d, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e68, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e4c, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            if (z2) {
                r0(sparseArray);
            } else {
                s0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z2) {
        uq4 uq4Var;
        uq4 uq4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, sparseArray, z2) == null) {
            yq4 yq4Var = new yq4(this.a.getContext());
            yq4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02db));
            yq4Var.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091e45) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e45)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e4b)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e4d) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e4d)).intValue() : -1) == 0) {
                    uq4Var2 = new uq4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04a1), yq4Var);
                } else {
                    uq4Var2 = new uq4(10, this.a.getString(R.string.obfuscated_res_0x7f0f0496), yq4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091e4b, sparseArray.get(R.id.obfuscated_res_0x7f091e4b));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e4d, sparseArray.get(R.id.obfuscated_res_0x7f091e4d));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e4c, sparseArray.get(R.id.obfuscated_res_0x7f091e4c));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                uq4Var2.d.setTag(sparseArray2);
                arrayList.add(uq4Var2);
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e56)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e57))) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                uq4 uq4Var3 = new uq4(11, this.a.getString(R.string.obfuscated_res_0x7f0f0640), yq4Var);
                uq4Var3.d.setTag(sparseArray3);
                arrayList.add(uq4Var3);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091e60, sparseArray.get(R.id.obfuscated_res_0x7f091e60));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e9c, sparseArray.get(R.id.obfuscated_res_0x7f091e9c));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e9d, sparseArray.get(R.id.obfuscated_res_0x7f091e9d));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e9b, sparseArray.get(R.id.obfuscated_res_0x7f091e9b));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e9e, sparseArray.get(R.id.obfuscated_res_0x7f091e9e));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e9f, sparseArray.get(R.id.obfuscated_res_0x7f091e9f));
                sparseArray4.put(R.id.obfuscated_res_0x7f091e9a, sparseArray.get(R.id.obfuscated_res_0x7f091e9a));
                if (z2) {
                    uq4Var = new uq4(12, this.a.getString(R.string.obfuscated_res_0x7f0f14b0), yq4Var);
                } else {
                    uq4Var = new uq4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b2f), yq4Var);
                }
                uq4Var.d.setTag(sparseArray4);
                arrayList.add(uq4Var);
            }
            yq4Var.j(arrayList);
            wq4 wq4Var = this.q;
            if (wq4Var == null) {
                this.q = new wq4(this.a.getPageContext(), yq4Var);
            } else {
                wq4Var.i(yq4Var);
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
        rq7 Q1;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.F() == null || this.a.F().Q1() == null || (O = (Q1 = this.a.F().Q1()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.a.h4();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        hu7 hu7Var = new hu7();
        int V = this.a.F().Q1().V();
        boolean z2 = true;
        if (V != 1 && V != 3) {
            hu7Var.g = false;
        } else {
            hu7Var.g = true;
            hu7Var.s = O.getIs_top() == 1;
        }
        if (Z(V)) {
            hu7Var.h = true;
            hu7Var.r = O.getIs_good() == 1;
        } else {
            hu7Var.h = false;
        }
        if (V == 1002 && !equals) {
            hu7Var.u = true;
        }
        hu7Var.n = y0(O.isBlocked(), Q1.i0(), equals, V, O.isWorksInfo(), O.isScoreThread());
        hu7Var.e = u0(equals, Q1.i0());
        hu7Var.i = z0();
        hu7Var.f = x0(equals);
        hu7Var.k = equals && Q1.U() != null && Q1.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            hu7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        hu7Var.t = equals;
        hu7Var.q = this.a.F().g2();
        hu7Var.b = true;
        hu7Var.a = b0(equals);
        hu7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        hu7Var.j = true;
        hu7Var.o = this.a.F().t1();
        hu7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            hu7Var.c = true;
        } else {
            hu7Var.c = false;
        }
        if (Q1.g0()) {
            hu7Var.b = false;
            hu7Var.d = false;
            hu7Var.c = false;
            hu7Var.g = false;
            hu7Var.h = false;
        }
        hu7Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !Q1.g0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2.M3(absVideoPbFragment2.F().Q1()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.a;
            hu7Var.w = absVideoPbFragment3.M3(absVideoPbFragment3.F().Q1()).Q;
        }
        if (O.isBlocked()) {
            hu7Var.n = false;
            hu7Var.g = false;
            hu7Var.h = false;
        }
        H0(hu7Var);
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
        sparseArray.put(R.id.obfuscated_res_0x7f091700, Integer.valueOf(this.O ? 2 : 3));
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
            return (absVideoPbFragment == null || absVideoPbFragment.F().Q1().l().getDeletedReasonInfo() == null || 1 != this.a.F().Q1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void r0(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e5f, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1192, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0366, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.N());
        tBAlertBuilder.p(R.string.obfuscated_res_0x7f0f0b2b);
        tBAlertBuilder.j(R.string.obfuscated_res_0x7f0f0b2c);
        tBAlertBuilder.l(true);
        tBAlertBuilder.o(aVar2, aVar);
        tBAlertBuilder.g(false);
        androidx.appcompat.app.AlertDialog s2 = tBAlertBuilder.s();
        aVar.a(new f(this, s2, sparseArray));
        aVar2.a(new g(this, s2));
    }

    public final void s0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048633, this, i2, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e5f, Boolean.TRUE);
        }
        ki5 ki5Var = new ki5(this.a.F().Q1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.F().Q1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.F().Q1().o().has_forum_rule.intValue());
        ki5Var.i(this.a.F().Q1().l().getId(), this.a.F().Q1().l().getName());
        ki5Var.h(this.a.F().Q1().l().getImage_url());
        ki5Var.j(this.a.F().Q1().l().getUser_level());
        C0(sparseArray, i2, ki5Var, this.a.F().Q1().U(), true);
    }

    public final void t0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            lw7.d(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final boolean u0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        do4 do4Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.F() == null || this.a.F().Q1() == null) {
                return false;
            }
            rq7 Q1 = this.a.F().Q1();
            ThreadData O = Q1.O();
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
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !rd6.isOn()) || this.a.F().H() || O.isWorksInfo() || O.isScoreThread() || z3) {
                return false;
            }
            if (Q1.l() == null || !Q1.l().isBlockBawuDelete) {
                if (Q1.O() == null || !Q1.O().isBlocked()) {
                    if (Q1.V() != 0) {
                        return Q1.V() != 3;
                    }
                    List<xp4> p2 = Q1.p();
                    if (ListUtils.getCount(p2) > 0) {
                        for (xp4 xp4Var : p2) {
                            if (xp4Var != null && (do4Var = xp4Var.g) != null && do4Var.a && !do4Var.c && ((i2 = do4Var.b) == 1 || i2 == 2)) {
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
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0496, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0366, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.N());
        tBAlertBuilder.p(i2);
        tBAlertBuilder.j(i3);
        tBAlertBuilder.l(true);
        tBAlertBuilder.o(aVar2, aVar);
        tBAlertBuilder.g(false);
        androidx.appcompat.app.AlertDialog s2 = tBAlertBuilder.s();
        aVar.a(new d(this, s2, sparseArray));
        aVar2.a(new e(this, s2));
    }

    public void w0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        PostData postData;
        uq4 uq4Var;
        uq4 uq4Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, sparseArray) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.F() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e49)) == null) {
            return;
        }
        if (this.c == null) {
            yq4 yq4Var = new yq4(this.a.getContext());
            this.c = yq4Var;
            yq4Var.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = this.a.F().Q1() != null && this.a.F().Q1().g0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e4c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091e8c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8c)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091e8a) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8a)).booleanValue() : false;
            uq4 uq4Var3 = null;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091e59) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e59) : null;
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
                uq4 uq4Var4 = new uq4(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091e49, postData);
                uq4Var4.d.setTag(sparseArray2);
                arrayList.add(uq4Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    uq4 uq4Var5 = new uq4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b33), this.c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea0, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e60, sparseArray.get(R.id.obfuscated_res_0x7f091e60));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e9c, sparseArray.get(R.id.obfuscated_res_0x7f091e9c));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e9d, sparseArray.get(R.id.obfuscated_res_0x7f091e9d));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e9b, sparseArray.get(R.id.obfuscated_res_0x7f091e9b));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e9e, sparseArray.get(R.id.obfuscated_res_0x7f091e9e));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e9f, sparseArray.get(R.id.obfuscated_res_0x7f091e9f));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e4c, sparseArray.get(R.id.obfuscated_res_0x7f091e4c));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e4d, sparseArray.get(R.id.obfuscated_res_0x7f091e4d));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e4b, sparseArray.get(R.id.obfuscated_res_0x7f091e4b));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                    uq4Var5.d.setTag(sparseArray3);
                    arrayList.add(uq4Var5);
                } else {
                    if ((b0(booleanValue) && TbadkCoreApplication.isLogin()) && !z2) {
                        uq4 uq4Var6 = new uq4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0fdb), this.c);
                        uq4Var6.d.setTag(str);
                        arrayList.add(uq4Var6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e8c, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e56, sparseArray.get(R.id.obfuscated_res_0x7f091e56));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e57, sparseArray.get(R.id.obfuscated_res_0x7f091e57));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e59, str);
                    if (booleanValue4) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ea0, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e60, sparseArray.get(R.id.obfuscated_res_0x7f091e60));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e9c, sparseArray.get(R.id.obfuscated_res_0x7f091e9c));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e9d, sparseArray.get(R.id.obfuscated_res_0x7f091e9d));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e9b, sparseArray.get(R.id.obfuscated_res_0x7f091e9b));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e9e, sparseArray.get(R.id.obfuscated_res_0x7f091e9e));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e9f, sparseArray.get(R.id.obfuscated_res_0x7f091e9f));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ea0, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e8a, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e4c, Boolean.valueOf(booleanValue));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e4b, sparseArray.get(R.id.obfuscated_res_0x7f091e4b));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e4d, sparseArray.get(R.id.obfuscated_res_0x7f091e4d));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e5d, sparseArray.get(R.id.obfuscated_res_0x7f091e5d));
                        uq4 uq4Var7 = new uq4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0496), this.c);
                        uq4Var7.d.setTag(sparseArray4);
                        uq4Var3 = uq4Var7;
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e8a, Boolean.FALSE);
                    }
                    uq4 uq4Var8 = new uq4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02db), this.c);
                    uq4Var8.d.setTag(sparseArray4);
                    uq4Var2 = uq4Var8;
                    uq4Var = uq4Var3;
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e8c, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea0, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e8a, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e68, sparseArray.get(R.id.obfuscated_res_0x7f091e68));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e4c, Boolean.valueOf(booleanValue));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e4b, sparseArray.get(R.id.obfuscated_res_0x7f091e4b));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e4d, sparseArray.get(R.id.obfuscated_res_0x7f091e4d));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e5d, sparseArray.get(R.id.obfuscated_res_0x7f091e5d));
                    if (this.a.F().Q1().V() == 1002 && !booleanValue) {
                        uq4Var = new uq4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0fdb), this.c);
                    } else {
                        uq4Var = new uq4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0496), this.c);
                    }
                    uq4Var.d.setTag(sparseArray5);
                    uq4Var2 = null;
                } else {
                    uq4Var = null;
                    uq4Var2 = null;
                }
                if (uq4Var != null) {
                    arrayList.add(uq4Var);
                }
                if (uq4Var2 != null) {
                    arrayList.add(uq4Var2);
                }
                if (!booleanValue) {
                    arrayList.add(new uq4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0316), this.c));
                }
            }
            this.c.j(arrayList);
            wq4 wq4Var = new wq4(this.a.getPageContext(), this.c);
            this.b = wq4Var;
            wq4Var.m();
        }
    }

    public final boolean x0(boolean z2) {
        InterceptResult invokeZ;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048638, this, z2)) == null) {
            if (z2 || (absVideoPbFragment = this.a) == null || absVideoPbFragment.F() == null || this.a.F().Q1() == null || (this.a.F().Q1().l() != null && this.a.F().Q1().l().isBlockBawuDelete)) {
                return false;
            }
            rq7 Q1 = this.a.F().Q1();
            if ((Q1.O() == null || Q1.O().getAuthor() == null || !Q1.O().getAuthor().isForumBusinessAccount() || rd6.isOn()) && !this.a.F().H()) {
                return ((Q1.O() != null && Q1.O().isBlocked()) || this.a.F().Q1().V() == 0 || this.a.F().Q1().V() == 3) ? false : true;
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
            if (absVideoPbFragment == null || absVideoPbFragment.F() == null || !this.a.F().g2()) {
                return false;
            }
            return this.a.F().O1() == null || this.a.F().O1().c() != 0;
        }
        return invokeV.booleanValue;
    }
}
