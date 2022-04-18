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
import com.repackage.cr4;
import com.repackage.er4;
import com.repackage.i35;
import com.repackage.nr4;
import com.repackage.yh5;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.ForumToolPerm;
/* loaded from: classes7.dex */
public class xz7 {
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
    public rt4 J;
    public sk8 K;
    public boolean L;
    public final View.OnLongClickListener M;
    public nr4.e N;
    public boolean O;
    public final er4.c P;
    public AbsVideoPbFragment a;
    public lr4 b;
    public nr4 c;
    public lr4 d;
    public cr4 e;
    public Dialog f;
    public Dialog g;
    public gr4 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public lr4 q;
    public xt4 r;
    public er4 s;
    public AlertDialog t;
    public rv7 u;
    public yh5 v;
    public bi5 w;
    public ey7 x;
    public PbFragment.d3 y;
    public kw7 z;

    /* loaded from: classes7.dex */
    public class a implements er4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz7 a;

        public a(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz7Var;
        }

        @Override // com.repackage.er4.c
        public void a(er4 er4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, er4Var, i, view2) == null) {
                if (er4Var != null) {
                    er4Var.e();
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
                        xz7 xz7Var = this.a;
                        xz7Var.z = new kw7(xz7Var.a.getPageContext());
                    }
                    this.a.z.b(this.a.B, this.a.A.n());
                }
                this.a.A = null;
                this.a.B = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ xz7 e;

        public a0(xz7 xz7Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = xz7Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.repackage.nr4.e
        public void onItemClick(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.g0(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e58), ((Integer) this.a.get(R.id.obfuscated_res_0x7f091e75)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f091e59)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f091ea8);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f091eaa);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f091ea9);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.D);
                    userMuteAddAndDelCustomMessage.setTag(this.e.D);
                    this.e.L0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f091ea6));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz7 a;

        public b(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz7Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.a.H2(cr4Var, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz7 a;

        public b0(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz7Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                TiebaStatic.log("c10025");
                cr4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ xz7 c;

        public d(xz7 xz7Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xz7Var;
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
                    oi.M(this.c.a.x(), R.string.obfuscated_res_0x7f0f0c17);
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

        public e(xz7 xz7Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, alertDialog};
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
        public final /* synthetic */ xz7 c;

        public f(xz7 xz7Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xz7Var;
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
                    oi.M(this.c.a.x(), R.string.obfuscated_res_0x7f0f0c17);
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

        public g(xz7 xz7Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, alertDialog};
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
        public final /* synthetic */ cr4 a;
        public final /* synthetic */ xz7 b;

        public h(xz7 xz7Var, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz7Var;
            this.a = cr4Var;
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
        public final /* synthetic */ xz7 b;

        public i(xz7 xz7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz7Var;
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
    public class j implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ xz7 b;

        public j(xz7 xz7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz7Var;
            this.a = z;
        }

        @Override // com.repackage.nr4.e
        public void onItemClick(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                this.b.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e58), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e75)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).booleanValue());
                        return;
                    case 11:
                        if (this.b.y != null) {
                            this.b.y.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f091e75), sparseArray.get(R.id.obfuscated_res_0x7f091e63), sparseArray.get(R.id.obfuscated_res_0x7f091e66), sparseArray.get(R.id.obfuscated_res_0x7f091e64), sparseArray.get(R.id.obfuscated_res_0x7f091e65)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.T(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea7), sparseArray);
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
        public final /* synthetic */ xz7 a;

        public k(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz7Var;
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
    public class l implements er4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz7 a;

        public l(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz7Var;
        }

        @Override // com.repackage.er4.c
        public void a(er4 er4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, er4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    xz7 xz7Var = this.a;
                    xz7Var.H = xz7Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new lu7(this.a.a.w().l1(), this.a.H, "1").start();
                    er4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    xz7 xz7Var2 = this.a;
                    xz7Var2.H = xz7Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new lu7(this.a.a.w().l1(), this.a.H, "2").start();
                    er4Var.e();
                } else if (i == 2) {
                    xz7 xz7Var3 = this.a;
                    xz7Var3.H = xz7Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    er4Var.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr4 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ xz7 c;

        public m(xz7 xz7Var, lr4 lr4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, lr4Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xz7Var;
            this.a = lr4Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.w().i1() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.repackage.nr4.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(nr4 nr4Var, int i, View view2) {
            boolean K2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, nr4Var, i, view2) != null) {
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
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091721 ? 1 : 0).param("obj_type", i2));
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
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091721 ? 1 : 0).param("obj_type", i2));
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
    public class n implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public n(xz7 xz7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, metaData};
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

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ xz7 b;

        public o(xz7 xz7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz7Var;
            this.a = metaData;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                cr4Var.dismiss();
                if (this.b.a.O2() != null) {
                    this.b.a.O2().l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.a.getPageContext().getUniqueId(), this.b.a.w().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ xz7 b;

        public q(xz7 xz7Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz7Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.b.B0();
                MessageManager.getInstance().sendMessage(this.a);
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ er4.c a;
        public final /* synthetic */ xz7 b;

        public s(xz7 xz7Var, er4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz7Var;
            this.a = cVar;
        }

        @Override // com.repackage.nr4.e
        public void onItemClick(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz7 a;

        public t(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz7Var;
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
        public final /* synthetic */ xz7 a;

        public u(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz7Var;
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
        public final /* synthetic */ xz7 a;

        public v(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz7Var;
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
        public final /* synthetic */ xz7 a;

        public w(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.d3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!mi.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.w().T0().l().getId(), this.a.a.w().T0().l().getName(), this.a.a.w().T0().O().getId(), String.valueOf(this.a.a.w().T0().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz7 a;

        public x(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz7Var;
        }

        @Override // com.repackage.nr4.e
        public void onItemClick(nr4 nr4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.M0(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091699);
                        this.a.n0(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091698);
                        this.a.n0(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09169b);
                        AgreeView agreeView = (AgreeView) view5;
                        this.a.n0(view5);
                        if (agreeView == null || agreeView.getImgDisagree() == null) {
                            return;
                        }
                        agreeView.getImgDisagree().performClick();
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09169b);
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
                            xz7 xz7Var = this.a;
                            xz7Var.z = new kw7(xz7Var.a.getPageContext());
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
                            xz7 xz7Var2 = this.a;
                            int S = xz7Var2.S(xz7Var2.a.w().T0());
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
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
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
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091eab)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e69, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f091e52, 2);
                                this.a.B(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091e5a) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e58) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e75) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091e59) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e59)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e75)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091e6a)).booleanValue();
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
                                    this.a.i0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e58), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.a.t0(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.a.g0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091e58), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!mi.z()) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e98)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e96)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eab)).booleanValue();
                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f091e6e) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e6e)).booleanValue() : false;
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.a.g0(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091e58), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091e75)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091e59)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e69, 1);
                            sparseArray4.put(R.id.obfuscated_res_0x7f091e52, 2);
                            this.a.B(sparseArray4);
                            return;
                        } else {
                            if (booleanValue6) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f091e52, 2);
                            }
                            this.a.l0(view2);
                            return;
                        }
                    case 8:
                        if (ViewHelper.checkUpIsLogin(this.a.a.getContext()) && (sparseArray = (SparseArray) view2.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e56);
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
                        this.a.a.x().showBlockDialog(as8.b(view2));
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ xz7 d;

        public y(xz7 xz7Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xz7Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                if (cr4Var != null) {
                    cr4Var.dismiss();
                }
                this.d.a.I2(((Integer) this.a.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091e58), this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(xz7 xz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755154212, "Lcom/repackage/xz7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755154212, "Lcom/repackage/xz7;");
        }
    }

    public xz7(AbsVideoPbFragment absVideoPbFragment) {
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
        ey7 ey7Var = new ey7(this.a.getContext());
        this.x = ey7Var;
        ey7Var.b(this.a.getUniqueId());
        this.y = new w(this);
    }

    public void A0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) || metaData == null) {
            return;
        }
        cr4 cr4Var = new cr4(this.a.getActivity());
        cr4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a82));
        cr4Var.setTitleShowCenter(true);
        cr4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a83));
        cr4Var.setMessageShowCenter(true);
        cr4Var.setCancelable(false);
        cr4Var.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a84), new n(this, metaData));
        cr4Var.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a85), new o(this, metaData));
        cr4Var.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            B0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = mg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = mg.g((String) sparseArray.get(R.id.obfuscated_res_0x7f091ea7), 0L);
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
                this.r = new xt4(this.a.getPageContext());
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
            this.J = new rt4();
        }
        if (this.K == null) {
            sk8 sk8Var = new sk8();
            this.K = sk8Var;
            sk8Var.a = this.a.getUniqueId();
        }
        vn4 vn4Var = new vn4();
        vn4Var.b = 5;
        vn4Var.h = 8;
        vn4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.w() != null) {
            vn4Var.f = this.a.w().S0();
        }
        vn4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                vn4Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment != null || absVideoPbFragment.w() == null || this.a.w().T0() == null) {
                    return;
                }
                this.J.b(this.a.x(), vn4Var, agreeData, this.a.w().T0().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            vn4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            vn4Var.i = 1;
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
        lp4 lp4Var = new lp4();
        lp4Var.j(sparseArray2);
        this.w.E(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04a9), this.a.getString(R.string.obfuscated_res_0x7f0f04aa), this.a.getString(R.string.obfuscated_res_0x7f0f04ab), this.a.getString(R.string.obfuscated_res_0x7f0f04ac), this.a.getString(R.string.obfuscated_res_0x7f0f04ad)});
        this.w.D(lp4Var);
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
            cr4 cr4Var = new cr4(this.a.getPageContext().getPageActivity());
            cr4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b17));
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ccb, new b0(this));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new c0(this));
            cr4Var.create(this.a.getPageContext()).show();
        }
    }

    public final boolean E(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        List<jr4> b2;
        jr4 jr4Var;
        jr4 jr4Var2;
        jr4 jr4Var3;
        jr4 jr4Var4;
        jr4 jr4Var5;
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
                        if (view2.getTag(R.id.obfuscated_res_0x7f091e8c) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e8c) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8c);
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
                        if (view2.getTag(R.id.obfuscated_res_0x7f091e8c) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e8c) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8c);
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f091e8c) != null && (view2.getTag(R.id.obfuscated_res_0x7f091e8c) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091e8c);
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
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e56);
            this.G = postData;
            if (postData == null || this.a.b3() == null) {
                return true;
            }
            boolean z5 = this.a.b3().e() && this.G.I() != null && this.G.I().equals(this.a.w().O0());
            boolean z6 = this.a.w().T0() != null && this.a.w().T0().g0();
            if (this.c == null) {
                nr4 nr4Var = new nr4(this.a.getContext());
                this.c = nr4Var;
                nr4Var.n(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 == null || sparseArray == null) {
                return true;
            }
            boolean z7 = Y(view2) && !z6;
            boolean z8 = (!Y(view2) || (foVar = this.A) == null || foVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e6f) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6f)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e59) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091e98) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e98)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091e96) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e96)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091e66) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e66) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091e6e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6e)).booleanValue() : false;
            if (z7) {
                z4 = booleanValue7;
                z3 = booleanValue6;
                z2 = booleanValue5;
                arrayList.add(new jr4(1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f106e), this.c));
            } else {
                z2 = booleanValue5;
                z3 = booleanValue6;
                z4 = booleanValue7;
            }
            if (z8) {
                arrayList.add(new jr4(2, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f106f), this.c));
            }
            if (!z7 && !z8) {
                jr4 jr4Var6 = new jr4(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f043c), this.c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091e56, this.G);
                jr4Var6.d.setTag(sparseArray3);
                arrayList.add(jr4Var6);
            }
            if (!booleanValue && !z6) {
                if (z5) {
                    jr4Var5 = new jr4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f84), this.c);
                } else {
                    jr4Var5 = new jr4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a81), this.c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091e56, this.G);
                sparseArray4.put(R.id.obfuscated_res_0x7f091e6f, Boolean.FALSE);
                jr4Var5.d.setTag(sparseArray4);
                arrayList.add(jr4Var5);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    jr4 jr4Var7 = new jr4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b18), this.c);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eaa, sparseArray.get(R.id.obfuscated_res_0x7f091eaa));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                    jr4Var7.d.setTag(sparseArray5);
                    arrayList.add(jr4Var7);
                } else {
                    if ((b0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                        jr4 jr4Var8 = new jr4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa8), this.c);
                        jr4Var8.d.setTag(str);
                        arrayList.add(jr4Var8);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e98, Boolean.TRUE);
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e64, sparseArray.get(R.id.obfuscated_res_0x7f091e64));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e65, sparseArray.get(R.id.obfuscated_res_0x7f091e65));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091e66, str);
                    if (!X() && z2) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eaa, sparseArray.get(R.id.obfuscated_res_0x7f091eaa));
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e96, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(booleanValue2));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e6a, sparseArray.get(R.id.obfuscated_res_0x7f091e6a));
                        if (z4) {
                            jr4 jr4Var9 = new jr4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495), this.c);
                            jr4Var9.d.setTag(sparseArray6);
                            jr4Var4 = jr4Var9;
                            jr4Var = new jr4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02d4), this.c);
                            jr4Var.d.setTag(sparseArray6);
                            jr4Var2 = jr4Var4;
                        }
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091e96, Boolean.FALSE);
                    }
                    jr4Var4 = null;
                    jr4Var = new jr4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02d4), this.c);
                    jr4Var.d.setTag(sparseArray6);
                    jr4Var2 = jr4Var4;
                } else if (z3) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e98, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e96, Boolean.TRUE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(booleanValue2));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091e6a, sparseArray.get(R.id.obfuscated_res_0x7f091e6a));
                    if (this.a.w().T0().V() == 1002 && !booleanValue2) {
                        jr4Var3 = new jr4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa8), this.c);
                    } else {
                        jr4Var3 = new jr4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0495), this.c);
                    }
                    jr4Var3.d.setTag(sparseArray7);
                    jr4Var2 = jr4Var3;
                    jr4Var = null;
                } else {
                    jr4Var = null;
                    jr4Var2 = null;
                }
                if (jr4Var2 != null) {
                    arrayList.add(jr4Var2);
                }
                if (jr4Var != null) {
                    arrayList.add(jr4Var);
                }
                yx7.a(arrayList, this.c, this.G, this.a.w());
            }
            if (UbsABTestHelper.isPBPlanA()) {
                b2 = yx7.c(arrayList, this.G.q(), sparseArray, this.c);
            } else {
                b2 = yx7.b(arrayList, this.G.q(), sparseArray, this.c);
            }
            yx7.k(b2, this.O);
            yx7.e(b2);
            this.c.o(yx7.f(this.G));
            if (UbsABTestHelper.isPBPlanA()) {
                this.c.k(b2, false);
            } else {
                this.c.k(b2, true);
            }
            lr4 lr4Var = new lr4(this.a.getPageContext(), this.c);
            this.b = lr4Var;
            lr4Var.m();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.a.w().l1()).param("fid", this.a.w().getForumId()).param("uid", this.a.w().T0().O().getAuthor().getUserId()).param("post_id", this.a.w().A()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f091ea7) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f091e52) instanceof Integer)) {
            lr4 lr4Var = this.b;
            if (lr4Var != null && lr4Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea5);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea7);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue()) {
                nr4 nr4Var = new nr4(this.a.getBaseFragmentActivity());
                nr4Var.n(new a0(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e52) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e52)).intValue() : -1) == 1) {
                    arrayList.add(new jr4(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0495), nr4Var));
                }
                if (z2) {
                    arrayList.add(new jr4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1467), nr4Var));
                } else {
                    arrayList.add(new jr4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b14), nr4Var));
                }
                nr4Var.j(arrayList);
                lr4 lr4Var2 = new lr4(this.a.getPageContext(), nr4Var);
                this.b = lr4Var2;
                lr4Var2.m();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.a.o3();
            lr4 lr4Var = this.b;
            if (lr4Var != null) {
                lr4Var.dismiss();
            }
            this.a.p3();
            K();
        }
    }

    public void F0(er4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, cVar, z2) == null) {
            lr4 lr4Var = this.d;
            if (lr4Var != null) {
                lr4Var.dismiss();
                this.d = null;
            }
            nr4 nr4Var = new nr4(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.w().T0() != null && this.a.w().T0().O() != null && !this.a.w().T0().O().isBjh()) {
                arrayList.add(new jr4(0, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f106e), nr4Var));
            }
            if (!z2) {
                arrayList.add(new jr4(1, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f106f), nr4Var));
            }
            nr4Var.j(arrayList);
            nr4Var.n(new s(this, cVar));
            lr4 lr4Var2 = new lr4(this.a.getPageContext(), nr4Var);
            this.d = lr4Var2;
            lr4Var2.m();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.a.o3();
            lr4 lr4Var = this.b;
            if (lr4Var != null) {
                lr4Var.dismiss();
            }
            K();
        }
    }

    public void G0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            gr4 gr4Var = this.h;
            if (gr4Var != null) {
                gr4Var.d();
                this.h = null;
            }
            if (this.a.w() == null) {
                return;
            }
            ArrayList<pr4> arrayList = new ArrayList<>();
            arrayList.add(new pr4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0267), "", this.a.w().c1() == 1, Integer.toString(1)));
            arrayList.add(new pr4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b25), "", this.a.w().c1() == 2, Integer.toString(5)));
            arrayList.add(new pr4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b21), "", this.a.w().c1() == 3, Integer.toString(6)));
            arrayList.add(new pr4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b3c), "", this.a.w().c1() == 4, Integer.toString(7)));
            gr4 gr4Var2 = new gr4(this.a.getPageContext());
            gr4Var2.l(R.string.obfuscated_res_0x7f0f0db9);
            this.h = gr4Var2;
            gr4Var2.k(arrayList, onItemClickListener);
            gr4Var2.c();
            this.h.n();
        }
    }

    public void H() {
        lr4 lr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (lr4Var = this.b) == null) {
            return;
        }
        lr4Var.dismiss();
    }

    public void H0(sv7 sv7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, sv7Var) == null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new rv7(absVideoPbFragment, absVideoPbFragment.D1);
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
        this.u.M(sv7Var == null ? false : sv7Var.a);
        this.u.z(sv7Var == null ? false : sv7Var.n);
        this.u.B(sv7Var == null ? false : sv7Var.e);
        this.u.G(sv7Var == null ? false : sv7Var.i);
        this.u.C(sv7Var == null ? false : sv7Var.f);
        this.u.O(sv7Var != null ? sv7Var.c : true);
        this.u.L(sv7Var == null ? false : sv7Var.k);
        this.u.D(sv7Var == null ? false : sv7Var.l, sv7Var.t);
        if (sv7Var == null) {
            this.u.I(false, false);
            this.u.H(false, false);
        } else {
            this.u.I(sv7Var.g, sv7Var.s);
            this.u.H(sv7Var.h, sv7Var.r);
        }
        boolean z2 = sv7Var == null ? false : sv7Var.q;
        boolean z3 = sv7Var == null ? false : sv7Var.o;
        boolean z4 = sv7Var == null ? false : sv7Var.d;
        boolean z5 = sv7Var == null ? false : sv7Var.b;
        boolean z6 = sv7Var == null ? false : sv7Var.p;
        boolean z7 = sv7Var == null ? false : sv7Var.j;
        boolean z8 = sv7Var == null ? false : sv7Var.m;
        this.u.E(z4, z3);
        this.u.N(z5, z2);
        this.u.K(z7, z6);
        this.u.Q(z8);
        if (sv7Var != null) {
            rv7 rv7Var = this.u;
            boolean z9 = sv7Var.u;
            rv7Var.w = z9;
            if (z9) {
                rv7Var.h().setText(R.string.obfuscated_res_0x7f0f0fa8);
                this.u.C(false);
            }
        }
        this.u.A(sv7Var != null ? sv7Var.v : false);
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

    public final void I0(cr4 cr4Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, cr4Var, i2) == null) || (absVideoPbFragment = this.a) == null || cr4Var == null) {
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
        lp4 lp4Var = new lp4();
        lp4Var.j(sparseArray);
        this.v.y(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04a9), this.a.getString(R.string.obfuscated_res_0x7f0f04aa), this.a.getString(R.string.obfuscated_res_0x7f0f04ab), this.a.getString(R.string.obfuscated_res_0x7f0f04ac), this.a.getString(R.string.obfuscated_res_0x7f0f04ad)});
        this.v.x(lp4Var);
        this.v.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.v.z(new h(this, cr4Var));
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
        lr4 lr4Var = new lr4(this.a.getPageContext());
        if (this.a.w().T0().f == null || this.a.w().T0().f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1191), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1192)};
        } else {
            strArr = new String[this.a.w().T0().f.size()];
            for (int i2 = 0; i2 < this.a.w().T0().f.size(); i2++) {
                strArr[i2] = this.a.w().T0().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f118f);
            }
        }
        lr4Var.j(null, strArr, new m(this, lr4Var, view2));
        lr4Var.m();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            cr4 cr4Var = this.e;
            if (cr4Var != null) {
                cr4Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                rg.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                rg.b(dialog2, this.a.getPageContext());
            }
            lr4 lr4Var = this.q;
            if (lr4Var != null) {
                lr4Var.dismiss();
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
            cr4 cr4Var = new cr4(this.a.getPageContext().getPageActivity());
            cr4Var.setMessage(str);
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0984, new p(this));
            cr4Var.create(this.a.getPageContext()).show();
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
            cr4 cr4Var = new cr4(this.a.getBaseFragmentActivity());
            if (ni.isEmpty(str)) {
                cr4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0310, str3));
            } else {
                cr4Var.setMessage(str);
            }
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0421, new q(this, userMuteAddAndDelCustomMessage));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new r(this));
            cr4Var.create(this.a.getPageContext()).show();
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
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.w().l1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(yx7.m(i2))));
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public final void N0() {
        rv7 rv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (rv7Var = this.u) == null) {
            return;
        }
        rv7Var.y();
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

    public rv7 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.u : (rv7) invokeV.objValue;
    }

    public er4 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.s : (er4) invokeV.objValue;
    }

    public int S(bs7 bs7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, bs7Var)) == null) {
            if (bs7Var == null || bs7Var.O() == null) {
                return 0;
            }
            if (bs7Var.O().getThreadType() == 0) {
                return 1;
            }
            if (bs7Var.O().getThreadType() == 54) {
                return 2;
            }
            return bs7Var.O().getThreadType() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void T(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091ea8) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea8) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091eaa) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f091ea9) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea9) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f091ea5) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea5) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f091ea6) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea6) : "";
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
        xt4 xt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (xt4Var = this.r) == null) {
            return;
        }
        xt4Var.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.s == null) {
            this.s = new er4(this.a.getPageContext().getPageActivity());
            String[] strArr = {this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0363), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f118b), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10a0)};
            er4 er4Var = this.s;
            er4Var.j(strArr, new l(this));
            er4Var.g(er4.b.obfuscated_res_0x7f1003a4);
            er4Var.h(17);
            er4Var.c(this.a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? yx7.h(this.a.w()) : invokeV.booleanValue;
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
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e56)) == null) {
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

    public void f0(ArrayList<cp4> arrayList) {
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
                this.o = (ScrollView) this.i.findViewById(R.id.obfuscated_res_0x7f090ce0);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702de);
                this.g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f090cdf);
                TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907a1);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0907a2);
                this.k = textView2;
                textView2.setOnClickListener(this.a.Y2());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f139f));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    cp4 cp4Var = arrayList.get(i2);
                    if (cp4Var != null && !TextUtils.isEmpty(cp4Var.b()) && cp4Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(cp4Var.a()), cp4Var.b());
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
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e5a, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e75, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            int i4 = (i3 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f048a : R.string.obfuscated_res_0x7f0f0fa5;
            int i5 = R.string.obfuscated_res_0x7f0f0429;
            if (i2 == 0) {
                if (i3 != 1002 || z2) {
                    i5 = R.string.obfuscated_res_0x7f0f048e;
                    i4 = R.string.obfuscated_res_0x7f0f048f;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f0fa9;
                }
            }
            this.e = new cr4(this.a.getActivity());
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
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e5a, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e75, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            if (z2) {
                r0(sparseArray);
            } else {
                s0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z2) {
        jr4 jr4Var;
        jr4 jr4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, sparseArray, z2) == null) {
            nr4 nr4Var = new nr4(this.a.getContext());
            nr4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02d4));
            nr4Var.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091e52) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e52)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e58)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091e5a) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e5a)).intValue() : -1) == 0) {
                    jr4Var2 = new jr4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04a0), nr4Var);
                } else {
                    jr4Var2 = new jr4(10, this.a.getString(R.string.obfuscated_res_0x7f0f0495), nr4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                jr4Var2.d.setTag(sparseArray2);
                arrayList.add(jr4Var2);
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e63)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e64))) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e64, sparseArray.get(R.id.obfuscated_res_0x7f091e64));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e65, sparseArray.get(R.id.obfuscated_res_0x7f091e65));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e66, sparseArray.get(R.id.obfuscated_res_0x7f091e66));
                jr4 jr4Var3 = new jr4(11, this.a.getString(R.string.obfuscated_res_0x7f0f063d), nr4Var);
                jr4Var3.d.setTag(sparseArray3);
                arrayList.add(jr4Var3);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                sparseArray4.put(R.id.obfuscated_res_0x7f091eaa, sparseArray.get(R.id.obfuscated_res_0x7f091eaa));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea5, sparseArray.get(R.id.obfuscated_res_0x7f091ea5));
                if (z2) {
                    jr4Var = new jr4(12, this.a.getString(R.string.obfuscated_res_0x7f0f1467), nr4Var);
                } else {
                    jr4Var = new jr4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b14), nr4Var);
                }
                jr4Var.d.setTag(sparseArray4);
                arrayList.add(jr4Var);
            }
            nr4Var.j(arrayList);
            lr4 lr4Var = this.q;
            if (lr4Var == null) {
                this.q = new lr4(this.a.getPageContext(), nr4Var);
            } else {
                lr4Var.i(nr4Var);
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
        bs7 T0;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.w() == null || this.a.w().T0() == null || (O = (T0 = this.a.w().T0()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.a.o3();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        sv7 sv7Var = new sv7();
        int V = this.a.w().T0().V();
        boolean z2 = true;
        if (V != 1 && V != 3) {
            sv7Var.g = false;
        } else {
            sv7Var.g = true;
            sv7Var.s = O.getIs_top() == 1;
        }
        if (Z(V)) {
            sv7Var.h = true;
            sv7Var.r = O.getIs_good() == 1;
        } else {
            sv7Var.h = false;
        }
        if (V == 1002 && !equals) {
            sv7Var.u = true;
        }
        sv7Var.n = y0(O.isBlocked(), T0.i0(), equals, V, O.isWorksInfo(), O.isScoreThread());
        sv7Var.e = u0(equals, T0.i0());
        sv7Var.i = z0();
        sv7Var.f = x0(equals);
        sv7Var.k = equals && T0.U() != null && T0.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            sv7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        sv7Var.t = equals;
        sv7Var.q = this.a.w().j1();
        sv7Var.b = true;
        sv7Var.a = b0(equals);
        sv7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        sv7Var.j = true;
        sv7Var.o = this.a.w().w0();
        sv7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            sv7Var.c = true;
        } else {
            sv7Var.c = false;
        }
        if (T0.g0()) {
            sv7Var.b = false;
            sv7Var.d = false;
            sv7Var.c = false;
            sv7Var.g = false;
            sv7Var.h = false;
        }
        sv7Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !T0.g0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2.T2(absVideoPbFragment2.w().T0()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.a;
            sv7Var.w = absVideoPbFragment3.T2(absVideoPbFragment3.w().T0()).Q;
        }
        if (O.isBlocked()) {
            sv7Var.n = false;
            sv7Var.g = false;
            sv7Var.h = false;
        }
        H0(sv7Var);
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
        sparseArray.put(R.id.obfuscated_res_0x7f09172f, Integer.valueOf(this.O ? 2 : 3));
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
            sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1159, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036e, TBAlertConfig.OperateBtnStyle.SECONDARY);
        qr4 qr4Var = new qr4(this.a.x());
        qr4Var.v(R.string.obfuscated_res_0x7f0f0b10);
        qr4Var.l(R.string.obfuscated_res_0x7f0f0b11);
        qr4Var.n(true);
        qr4Var.r(aVar2, aVar);
        qr4Var.i(false);
        androidx.appcompat.app.AlertDialog y2 = qr4Var.y();
        aVar.a(new f(this, y2, sparseArray));
        aVar2.a(new g(this, y2));
    }

    public final void s0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048633, this, i2, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091e6c, Boolean.TRUE);
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
            yx7.d(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final boolean u0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        uo4 uo4Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.w() == null || this.a.w().T0() == null) {
                return false;
            }
            bs7 T0 = this.a.w().T0();
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
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !we6.isOn()) || this.a.w().G() || O.isWorksInfo() || O.isScoreThread() || z3) {
                return false;
            }
            if (T0.l() == null || !T0.l().isBlockBawuDelete) {
                if (T0.O() == null || !T0.O().isBlocked()) {
                    if (T0.V() != 0) {
                        return T0.V() != 3;
                    }
                    List<nq4> p2 = T0.p();
                    if (ListUtils.getCount(p2) > 0) {
                        for (nq4 nq4Var : p2) {
                            if (nq4Var != null && (uo4Var = nq4Var.g) != null && uo4Var.a && !uo4Var.c && ((i2 = uo4Var.b) == 1 || i2 == 2)) {
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
        qr4 qr4Var = new qr4(this.a.x());
        qr4Var.v(i2);
        qr4Var.l(i3);
        qr4Var.n(true);
        qr4Var.r(aVar2, aVar);
        qr4Var.i(false);
        androidx.appcompat.app.AlertDialog y2 = qr4Var.y();
        aVar.a(new d(this, y2, sparseArray));
        aVar2.a(new e(this, y2));
    }

    public void w0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        PostData postData;
        jr4 jr4Var;
        jr4 jr4Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, sparseArray) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.w() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e56)) == null) {
            return;
        }
        if (this.c == null) {
            nr4 nr4Var = new nr4(this.a.getContext());
            this.c = nr4Var;
            nr4Var.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = this.a.w().T0() != null && this.a.w().T0().g0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e59) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091e98) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e98)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091e96) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e96)).booleanValue() : false;
            jr4 jr4Var3 = null;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091e66) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091e66) : null;
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
                jr4 jr4Var4 = new jr4(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091e56, postData);
                jr4Var4.d.setTag(sparseArray2);
                arrayList.add(jr4Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    jr4 jr4Var5 = new jr4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b18), this.c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eaa, sparseArray.get(R.id.obfuscated_res_0x7f091eaa));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                    jr4Var5.d.setTag(sparseArray3);
                    arrayList.add(jr4Var5);
                } else {
                    if ((b0(booleanValue) && TbadkCoreApplication.isLogin()) && !z2) {
                        jr4 jr4Var6 = new jr4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0fa8), this.c);
                        jr4Var6.d.setTag(str);
                        arrayList.add(jr4Var6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e98, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e64, sparseArray.get(R.id.obfuscated_res_0x7f091e64));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e65, sparseArray.get(R.id.obfuscated_res_0x7f091e65));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091e66, str);
                    if (booleanValue4) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eaa, sparseArray.get(R.id.obfuscated_res_0x7f091eaa));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e96, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(booleanValue));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e6a, sparseArray.get(R.id.obfuscated_res_0x7f091e6a));
                        jr4 jr4Var7 = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0495), this.c);
                        jr4Var7.d.setTag(sparseArray4);
                        jr4Var3 = jr4Var7;
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091e96, Boolean.FALSE);
                    }
                    jr4 jr4Var8 = new jr4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02d4), this.c);
                    jr4Var8.d.setTag(sparseArray4);
                    jr4Var2 = jr4Var8;
                    jr4Var = jr4Var3;
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e98, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e96, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(booleanValue));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091e6a, sparseArray.get(R.id.obfuscated_res_0x7f091e6a));
                    if (this.a.w().T0().V() == 1002 && !booleanValue) {
                        jr4Var = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0fa8), this.c);
                    } else {
                        jr4Var = new jr4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0495), this.c);
                    }
                    jr4Var.d.setTag(sparseArray5);
                    jr4Var2 = null;
                } else {
                    jr4Var = null;
                    jr4Var2 = null;
                }
                if (jr4Var != null) {
                    arrayList.add(jr4Var);
                }
                if (jr4Var2 != null) {
                    arrayList.add(jr4Var2);
                }
                if (!booleanValue) {
                    arrayList.add(new jr4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0311), this.c));
                }
            }
            this.c.j(arrayList);
            lr4 lr4Var = new lr4(this.a.getPageContext(), this.c);
            this.b = lr4Var;
            lr4Var.m();
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
            bs7 T0 = this.a.w().T0();
            if ((T0.O() == null || T0.O().getAuthor() == null || !T0.O().getAuthor().isForumBusinessAccount() || we6.isOn()) && !this.a.w().G()) {
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
