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
import com.repackage.nr4;
import com.repackage.pr4;
import com.repackage.ri5;
import com.repackage.ui5;
import com.repackage.yr4;
import com.repackage.z35;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.ForumToolPerm;
/* loaded from: classes7.dex */
public class uz7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q = 0;
    public static int R = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public co A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public eu4 J;
    public pj8 K;
    public boolean L;
    public final View.OnLongClickListener M;
    public yr4.e N;
    public boolean O;
    public final pr4.c P;
    public AbsVideoPbFragment a;
    public wr4 b;
    public yr4 c;
    public wr4 d;
    public nr4 e;
    public Dialog f;
    public Dialog g;
    public rr4 h;
    public View i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public wr4 q;
    public ku4 r;
    public pr4 s;
    public AlertDialog t;
    public qv7 u;
    public ri5 v;
    public ui5 w;
    public by7 x;
    public PbFragment.d3 y;
    public jw7 z;

    /* loaded from: classes7.dex */
    public class a implements pr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz7 a;

        public a(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz7Var;
        }

        @Override // com.repackage.pr4.c
        public void a(pr4 pr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, pr4Var, i, view2) == null) {
                if (pr4Var != null) {
                    pr4Var.e();
                }
                if (this.a.A == null || TextUtils.isEmpty(this.a.B)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.B));
                    } else {
                        z35.a aVar = new z35.a();
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
                        uz7 uz7Var = this.a;
                        uz7Var.z = new jw7(uz7Var.a.getPageContext());
                    }
                    this.a.z.b(this.a.B, this.a.A.n());
                }
                this.a.A = null;
                this.a.B = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements yr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ uz7 e;

        public a0(uz7 uz7Var, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = uz7Var;
            this.a = sparseArray;
            this.b = z;
            this.c = str;
            this.d = str2;
        }

        @Override // com.repackage.yr4.e
        public void onItemClick(yr4 yr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                if (this.e.b != null) {
                    this.e.b.dismiss();
                }
                if (i == 0) {
                    this.e.g0(((Integer) this.a.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091eb0), ((Integer) this.a.get(R.id.obfuscated_res_0x7f091ecd)).intValue(), ((Boolean) this.a.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue());
                } else if (i == 1) {
                    String str = (String) this.a.get(R.id.obfuscated_res_0x7f091f00);
                    String str2 = (String) this.a.get(R.id.obfuscated_res_0x7f091f02);
                    String str3 = (String) this.a.get(R.id.obfuscated_res_0x7f091f01);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.b, this.c, str, str2, str3, 1, this.d, this.e.D);
                    userMuteAddAndDelCustomMessage.setTag(this.e.D);
                    this.e.L0(this.b, userMuteAddAndDelCustomMessage, this.d, str, (String) this.a.get(R.id.obfuscated_res_0x7f091efe));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz7 a;

        public b(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz7Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.a.a.I2(nr4Var, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz7 a;

        public b0(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz7Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                TiebaStatic.log("c10025");
                nr4Var.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ uz7 c;

        public d(uz7 uz7Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uz7Var;
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
                if (!ki.A()) {
                    mi.M(this.c.a.w(), R.string.obfuscated_res_0x7f0f0c2d);
                } else {
                    this.c.a.H2(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public e(uz7 uz7Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var, alertDialog};
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
        public final /* synthetic */ uz7 c;

        public f(uz7 uz7Var, androidx.appcompat.app.AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uz7Var;
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
                if (!ki.A()) {
                    mi.M(this.c.a.w(), R.string.obfuscated_res_0x7f0f0c2d);
                } else {
                    this.c.a.H2(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ androidx.appcompat.app.AlertDialog a;

        public g(uz7 uz7Var, androidx.appcompat.app.AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var, alertDialog};
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
    public class h implements ri5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nr4 a;
        public final /* synthetic */ uz7 b;

        public h(uz7 uz7Var, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var, nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uz7Var;
            this.a = nr4Var;
        }

        @Override // com.repackage.ri5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.I2(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements ui5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ uz7 b;

        public i(uz7 uz7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uz7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.ui5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.H2(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements yr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ uz7 b;

        public j(uz7 uz7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uz7Var;
            this.a = z;
        }

        @Override // com.repackage.yr4.e
        public void onItemClick(yr4 yr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                this.b.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb0), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ecd)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue());
                        return;
                    case 11:
                        if (this.b.y != null) {
                            this.b.y.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f091ecd), sparseArray.get(R.id.obfuscated_res_0x7f091ebb), sparseArray.get(R.id.obfuscated_res_0x7f091ebe), sparseArray.get(R.id.obfuscated_res_0x7f091ebc), sparseArray.get(R.id.obfuscated_res_0x7f091ebd)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.T(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f091eff), sparseArray);
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
        public final /* synthetic */ uz7 a;

        public k(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.t == null) {
                return;
            }
            pg.a(this.a.t, this.a.a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes7.dex */
    public class l implements pr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz7 a;

        public l(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz7Var;
        }

        @Override // com.repackage.pr4.c
        public void a(pr4 pr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, pr4Var, i, view2) == null) {
                if (i == 0) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    uz7 uz7Var = this.a;
                    uz7Var.H = uz7Var.H.trim();
                    UtilHelper.callPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new ku7(this.a.a.v().h2(), this.a.H, "1").start();
                    pr4Var.e();
                } else if (i == 1) {
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                    uz7 uz7Var2 = this.a;
                    uz7Var2.H = uz7Var2.H.trim();
                    UtilHelper.smsPhone(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    new ku7(this.a.a.v().h2(), this.a.H, "2").start();
                    pr4Var.e();
                } else if (i == 2) {
                    uz7 uz7Var3 = this.a;
                    uz7Var3.H = uz7Var3.H.trim();
                    UtilHelper.startBaiDuBar(this.a.a.getPageContext().getPageActivity(), this.a.H);
                    pr4Var.e();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements yr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr4 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ uz7 c;

        public m(uz7 uz7Var, wr4 wr4Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var, wr4Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uz7Var;
            this.a = wr4Var;
            this.b = view2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.c.a.v().e2() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // com.repackage.yr4.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(yr4 yr4Var, int i, View view2) {
            boolean G3;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, yr4Var, i, view2) != null) {
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
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091749 ? 1 : 0).param("obj_type", i2));
                if (this.c.a.v().P1().f != null && this.c.a.v().P1().f.size() > i) {
                    i = this.c.a.v().P1().f.get(i).sort_type.intValue();
                }
                G3 = this.c.a.v().G3(i);
                this.b.setTag(Integer.valueOf(this.c.a.v().d2()));
                if (G3) {
                    return;
                }
                this.c.a.t4(true);
                return;
            }
            i2 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.b.getId() != R.id.obfuscated_res_0x7f091749 ? 1 : 0).param("obj_type", i2));
            if (this.c.a.v().P1().f != null) {
                i = this.c.a.v().P1().f.get(i).sort_type.intValue();
            }
            G3 = this.c.a.v().G3(i);
            this.b.setTag(Integer.valueOf(this.c.a.v().d2()));
            if (G3) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        public n(uz7 uz7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var, metaData};
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

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 2));
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ uz7 b;

        public o(uz7 uz7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uz7Var;
            this.a = metaData;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.a.getUserId()).param("obj_locate", 1));
                nr4Var.dismiss();
                if (this.b.a.P2() != null) {
                    this.b.a.P2().l(!this.a.hadConcerned(), this.a.getPortrait(), this.a.getUserId(), this.a.isGod(), "6", this.b.a.getPageContext().getUniqueId(), this.b.a.v().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;
        public final /* synthetic */ uz7 b;

        public q(uz7 uz7Var, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uz7Var;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                this.b.B0();
                MessageManager.getInstance().sendMessage(this.a);
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public r(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s implements yr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr4.c a;
        public final /* synthetic */ uz7 b;

        public s(uz7 uz7Var, pr4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uz7Var;
            this.a = cVar;
        }

        @Override // com.repackage.yr4.e
        public void onItemClick(yr4 yr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                this.b.d.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz7 a;

        public t(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz7Var;
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
        public final /* synthetic */ uz7 a;

        public u(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz7Var;
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
        public final /* synthetic */ uz7 a;

        public v(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.g instanceof Dialog)) {
                pg.b(this.a.g, this.a.a.getPageContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements PbFragment.d3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz7 a;

        public w(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.d3
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!ki.z()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.a.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.a.getPageContext().getPageActivity(), this.a.a.v().P1().l().getId(), this.a.a.v().P1().l().getName(), this.a.a.v().P1().O().getId(), String.valueOf(this.a.a.v().P1().U().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements yr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz7 a;

        public x(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz7Var;
        }

        @Override // com.repackage.yr4.e
        public void onItemClick(yr4 yr4Var, int i, View view2) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yr4Var, i, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.M0(i);
                int i2 = 4;
                switch (i) {
                    case -4:
                        View view3 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0916c0);
                        this.a.n0(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view4 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0916bf);
                        this.a.n0(view4);
                        if (view4 != null) {
                            view4.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view5 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0916c2);
                        AgreeView agreeView = (AgreeView) view5;
                        this.a.n0(view5);
                        if (agreeView == null || agreeView.getImgDisagree() == null) {
                            return;
                        }
                        agreeView.getImgDisagree().performClick();
                        return;
                    case -1:
                        View view6 = (View) ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f0916c2);
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
                            z35.a aVar = new z35.a();
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
                            uz7 uz7Var = this.a;
                            uz7Var.z = new jw7(uz7Var.a.getPageContext());
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
                            if (this.a.a.v().P1().O() == null || this.a.a.v().P1().O().getAuthor() == null || this.a.a.v().P1().O().getAuthor().getUserId() == null || this.a.a.c3() == null) {
                                return;
                            }
                            uz7 uz7Var2 = this.a;
                            int S = uz7Var2.S(uz7Var2.a.v().P1());
                            ThreadData O = this.a.a.v().P1().O();
                            if (O.isBJHArticleThreadType()) {
                                i2 = 2;
                            } else if (O.isBJHVideoThreadType()) {
                                i2 = 3;
                            } else if (!O.isBJHNormalThreadType()) {
                                i2 = O.isBJHVideoDynamicThreadType() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.a.v().h2()).param("obj_locate", 2).param("obj_id", this.a.a.v().P1().O().getAuthor().getUserId()).param("obj_type", !this.a.a.c3().e()).param("obj_source", S).param("obj_param1", i2));
                            return;
                        }
                        return;
                    case 5:
                        if (!ki.z()) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
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
                            if ((sparseArray2.get(R.id.obfuscated_res_0x7f091f03) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091f03)).booleanValue()) {
                                sparseArray2.put(R.id.obfuscated_res_0x7f091ec1, 0);
                                sparseArray2.put(R.id.obfuscated_res_0x7f091eaa, 2);
                                this.a.B(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.obfuscated_res_0x7f091eb2) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091eb0) instanceof String) && (sparseArray3.get(R.id.obfuscated_res_0x7f091ecd) instanceof Integer) && (sparseArray3.get(R.id.obfuscated_res_0x7f091eb1) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091ecd)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.obfuscated_res_0x7f091ec2)).booleanValue();
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
                                    this.a.i0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091eb0), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.a.t0(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.a.g0(((Integer) sparseArray3.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) sparseArray3.get(R.id.obfuscated_res_0x7f091eb0), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!ki.z()) {
                            this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c2e);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view2.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eee)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091f03)).booleanValue();
                        boolean booleanValue6 = sparseArray4.get(R.id.obfuscated_res_0x7f091ec6) instanceof Boolean ? ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091ec6)).booleanValue() : false;
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.a.g0(((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) sparseArray4.get(R.id.obfuscated_res_0x7f091eb0), ((Integer) sparseArray4.get(R.id.obfuscated_res_0x7f091ecd)).intValue(), ((Boolean) sparseArray4.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.obfuscated_res_0x7f091ec1, 1);
                            sparseArray4.put(R.id.obfuscated_res_0x7f091eaa, 2);
                            this.a.B(sparseArray4);
                            return;
                        } else {
                            if (booleanValue6) {
                                sparseArray4.put(R.id.obfuscated_res_0x7f091eaa, 2);
                            }
                            this.a.l0(view2);
                            return;
                        }
                    case 8:
                        if (ViewHelper.checkUpIsLogin(this.a.a.getContext()) && (sparseArray = (SparseArray) view2.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eae);
                            if (postData2.q() == null) {
                                return;
                            }
                            g85 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
                        this.a.a.w().showBlockDialog(xq8.c(view2));
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ uz7 d;

        public y(uz7 uz7Var, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = uz7Var;
            this.a = sparseArray;
            this.b = i;
            this.c = z;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                if (nr4Var != null) {
                    nr4Var.dismiss();
                }
                this.d.a.J2(((Integer) this.a.get(R.id.obfuscated_res_0x7f091eb2)).intValue(), (String) this.a.get(R.id.obfuscated_res_0x7f091eb0), this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public z(uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755243585, "Lcom/repackage/uz7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755243585, "Lcom/repackage/uz7;");
        }
    }

    public uz7(AbsVideoPbFragment absVideoPbFragment) {
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
        by7 by7Var = new by7(this.a.getContext());
        this.x = by7Var;
        by7Var.b(this.a.getUniqueId());
        this.y = new w(this);
    }

    public void A0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) || metaData == null) {
            return;
        }
        nr4 nr4Var = new nr4(this.a.getActivity());
        nr4Var.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a89));
        nr4Var.setTitleShowCenter(true);
        nr4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a8a));
        nr4Var.setMessageShowCenter(true);
        nr4Var.setCancelable(false);
        nr4Var.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a8b), new n(this, metaData));
        nr4Var.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a8c), new o(this, metaData));
        nr4Var.create(this.a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            B0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = kg.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = kg.g((String) sparseArray.get(R.id.obfuscated_res_0x7f091eff), 0L);
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
                this.r = new ku4(this.a.getPageContext());
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
            this.J = new eu4();
        }
        if (this.K == null) {
            pj8 pj8Var = new pj8();
            this.K = pj8Var;
            pj8Var.a = this.a.getUniqueId();
        }
        fo4 fo4Var = new fo4();
        fo4Var.b = 5;
        fo4Var.h = 8;
        fo4Var.g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.v() != null) {
            fo4Var.f = this.a.v().O1();
        }
        fo4Var.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fo4Var.i = 0;
                this.J.c(agreeData, i2, this.a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.a;
                if (absVideoPbFragment != null || absVideoPbFragment.v() == null || this.a.v().P1() == null) {
                    return;
                }
                this.J.b(this.a.w(), fo4Var, agreeData, this.a.v().P1().O());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fo4Var.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fo4Var.i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.a;
        if (absVideoPbFragment != null) {
        }
    }

    public final void C0(SparseArray<Object> sparseArray, int i2, ti5 ti5Var, UserData userData, boolean z2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{sparseArray, Integer.valueOf(i2), ti5Var, userData, Boolean.valueOf(z2)}) == null) || (absVideoPbFragment = this.a) == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new ui5(this.a.getPageContext(), this.a.getView(), ti5Var, userData);
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
        wp4 wp4Var = new wp4();
        wp4Var.j(sparseArray2);
        this.w.E(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04b1), this.a.getString(R.string.obfuscated_res_0x7f0f04b2), this.a.getString(R.string.obfuscated_res_0x7f0f04b3), this.a.getString(R.string.obfuscated_res_0x7f0f04b4), this.a.getString(R.string.obfuscated_res_0x7f0f04b5)});
        this.w.D(wp4Var);
        this.w.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.F(new i(this, sparseArray));
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, mi.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
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
            nr4 nr4Var = new nr4(this.a.getPageContext().getPageActivity());
            nr4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b28));
            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0ce6, new b0(this));
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new c0(this));
            nr4Var.create(this.a.getPageContext()).show();
        }
    }

    public final boolean E(View view2) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z2;
        boolean z3;
        boolean z4;
        List<ur4> b2;
        ur4 ur4Var;
        ur4 ur4Var2;
        ur4 ur4Var3;
        ur4 ur4Var4;
        ur4 ur4Var5;
        co coVar;
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
                        if (view2.getTag(R.id.obfuscated_res_0x7f091ee4) != null && (view2.getTag(R.id.obfuscated_res_0x7f091ee4) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091ee4);
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
                        if (view2.getTag(R.id.obfuscated_res_0x7f091ee4) != null && (view2.getTag(R.id.obfuscated_res_0x7f091ee4) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091ee4);
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
                            if (view2.getTag(R.id.obfuscated_res_0x7f091ee4) != null && (view2.getTag(R.id.obfuscated_res_0x7f091ee4) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view2.getTag(R.id.obfuscated_res_0x7f091ee4);
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
            PostData postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eae);
            this.G = postData;
            if (postData == null || this.a.c3() == null) {
                return true;
            }
            boolean z5 = this.a.c3().e() && this.G.I() != null && this.G.I().equals(this.a.v().K1());
            boolean z6 = this.a.v().P1() != null && this.a.v().P1().g0();
            if (this.c == null) {
                yr4 yr4Var = new yr4(this.a.getContext());
                this.c = yr4Var;
                yr4Var.n(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view2 == null || sparseArray == null) {
                return true;
            }
            boolean z7 = Y(view2) && !z6;
            boolean z8 = (!Y(view2) || (coVar = this.A) == null || coVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091ec7) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ec7)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091eb1) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091f03) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f03)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091ef0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091f03) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f03)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.obfuscated_res_0x7f091eee) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eee)).booleanValue() : false;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ebe) : null;
            boolean booleanValue7 = sparseArray.get(R.id.obfuscated_res_0x7f091ec6) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ec6)).booleanValue() : false;
            if (z7) {
                z4 = booleanValue7;
                z3 = booleanValue6;
                z2 = booleanValue5;
                arrayList.add(new ur4(1, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1086), this.c));
            } else {
                z2 = booleanValue5;
                z3 = booleanValue6;
                z4 = booleanValue7;
            }
            if (z8) {
                arrayList.add(new ur4(2, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1087), this.c));
            }
            if (!z7 && !z8) {
                ur4 ur4Var6 = new ur4(3, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0444), this.c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091eae, this.G);
                ur4Var6.d.setTag(sparseArray3);
                arrayList.add(ur4Var6);
            }
            if (!booleanValue && !z6) {
                if (z5) {
                    ur4Var5 = new ur4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f9c), this.c);
                } else {
                    ur4Var5 = new ur4(4, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a87), this.c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091eae, this.G);
                sparseArray4.put(R.id.obfuscated_res_0x7f091ec7, Boolean.FALSE);
                ur4Var5.d.setTag(sparseArray4);
                arrayList.add(ur4Var5);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    ur4 ur4Var7 = new ur4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b29), this.c);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f091f03, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ec5, sparseArray.get(R.id.obfuscated_res_0x7f091ec5));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eff, sparseArray.get(R.id.obfuscated_res_0x7f091eff));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091f00, sparseArray.get(R.id.obfuscated_res_0x7f091f00));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091efe, sparseArray.get(R.id.obfuscated_res_0x7f091efe));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091f02, sparseArray.get(R.id.obfuscated_res_0x7f091f02));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eb1, sparseArray.get(R.id.obfuscated_res_0x7f091eb1));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eb2, sparseArray.get(R.id.obfuscated_res_0x7f091eb2));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eb0, sparseArray.get(R.id.obfuscated_res_0x7f091eb0));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ecd, sparseArray.get(R.id.obfuscated_res_0x7f091ecd));
                    ur4Var7.d.setTag(sparseArray5);
                    arrayList.add(ur4Var7);
                } else {
                    if ((b0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z6) {
                        ur4 ur4Var8 = new ur4(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fc0), this.c);
                        ur4Var8.d.setTag(str);
                        arrayList.add(ur4Var8);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.obfuscated_res_0x7f091ef0, Boolean.TRUE);
                    sparseArray6.put(R.id.obfuscated_res_0x7f091ecd, sparseArray.get(R.id.obfuscated_res_0x7f091ecd));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                    sparseArray6.put(R.id.obfuscated_res_0x7f091ebe, str);
                    if (!X() && z2) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091f03, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ec5, sparseArray.get(R.id.obfuscated_res_0x7f091ec5));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eff, sparseArray.get(R.id.obfuscated_res_0x7f091eff));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091f00, sparseArray.get(R.id.obfuscated_res_0x7f091f00));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091efe, sparseArray.get(R.id.obfuscated_res_0x7f091efe));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091f02, sparseArray.get(R.id.obfuscated_res_0x7f091f02));
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091f03, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eee, Boolean.TRUE);
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(booleanValue2));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eb0, sparseArray.get(R.id.obfuscated_res_0x7f091eb0));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eb2, sparseArray.get(R.id.obfuscated_res_0x7f091eb2));
                        sparseArray6.put(R.id.obfuscated_res_0x7f091ec2, sparseArray.get(R.id.obfuscated_res_0x7f091ec2));
                        if (z4) {
                            ur4 ur4Var9 = new ur4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049d), this.c);
                            ur4Var9.d.setTag(sparseArray6);
                            ur4Var4 = ur4Var9;
                            ur4Var = new ur4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02d9), this.c);
                            ur4Var.d.setTag(sparseArray6);
                            ur4Var2 = ur4Var4;
                        }
                    } else {
                        sparseArray6.put(R.id.obfuscated_res_0x7f091eee, Boolean.FALSE);
                    }
                    ur4Var4 = null;
                    ur4Var = new ur4(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02d9), this.c);
                    ur4Var.d.setTag(sparseArray6);
                    ur4Var2 = ur4Var4;
                } else if (z3) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.obfuscated_res_0x7f091ef0, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091f03, Boolean.FALSE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091eee, Boolean.TRUE);
                    sparseArray7.put(R.id.obfuscated_res_0x7f091ecd, sparseArray.get(R.id.obfuscated_res_0x7f091ecd));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(booleanValue2));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091eb0, sparseArray.get(R.id.obfuscated_res_0x7f091eb0));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091eb2, sparseArray.get(R.id.obfuscated_res_0x7f091eb2));
                    sparseArray7.put(R.id.obfuscated_res_0x7f091ec2, sparseArray.get(R.id.obfuscated_res_0x7f091ec2));
                    if (this.a.v().P1().V() == 1002 && !booleanValue2) {
                        ur4Var3 = new ur4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fc0), this.c);
                    } else {
                        ur4Var3 = new ur4(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049d), this.c);
                    }
                    ur4Var3.d.setTag(sparseArray7);
                    ur4Var2 = ur4Var3;
                    ur4Var = null;
                } else {
                    ur4Var = null;
                    ur4Var2 = null;
                }
                if (ur4Var2 != null) {
                    arrayList.add(ur4Var2);
                }
                if (ur4Var != null) {
                    arrayList.add(ur4Var);
                }
                vx7.a(arrayList, this.c, this.G, this.a.v());
            }
            if (UbsABTestHelper.isPBPlanA()) {
                b2 = vx7.c(arrayList, this.G.q(), sparseArray, this.c);
            } else {
                b2 = vx7.b(arrayList, this.G.q(), sparseArray, this.c);
            }
            vx7.k(b2, this.O);
            vx7.e(b2);
            this.c.o(vx7.f(this.G));
            if (UbsABTestHelper.isPBPlanA()) {
                this.c.k(b2, false);
            } else {
                this.c.k(b2, true);
            }
            wr4 wr4Var = new wr4(this.a.getPageContext(), this.c);
            this.b = wr4Var;
            wr4Var.m();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.a.v().h2()).param("fid", this.a.v().getForumId()).param("uid", this.a.v().P1().O().getAuthor().getUserId()).param("post_id", this.a.v().A()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0(boolean z2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2, sparseArray) == null) && (sparseArray.get(R.id.obfuscated_res_0x7f091eff) instanceof String) && (sparseArray.get(R.id.obfuscated_res_0x7f091f03) instanceof Boolean) && (sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Integer)) {
            wr4 wr4Var = this.b;
            if (wr4Var != null && wr4Var.isShowing()) {
                this.b.dismiss();
                this.b = null;
            }
            String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091efd);
            String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091eff);
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f03)).booleanValue()) {
                yr4 yr4Var = new yr4(this.a.getBaseFragmentActivity());
                yr4Var.n(new a0(this, sparseArray, z2, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).intValue() : -1) == 1) {
                    arrayList.add(new ur4(0, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f049d), yr4Var));
                }
                if (z2) {
                    arrayList.add(new ur4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f148f), yr4Var));
                } else {
                    arrayList.add(new ur4(1, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b25), yr4Var));
                }
                yr4Var.j(arrayList);
                wr4 wr4Var2 = new wr4(this.a.getPageContext(), yr4Var);
                this.b = wr4Var2;
                wr4Var2.m();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.a.p3();
            wr4 wr4Var = this.b;
            if (wr4Var != null) {
                wr4Var.dismiss();
            }
            this.a.q3();
            K();
        }
    }

    public void F0(pr4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, cVar, z2) == null) {
            wr4 wr4Var = this.d;
            if (wr4Var != null) {
                wr4Var.dismiss();
                this.d = null;
            }
            yr4 yr4Var = new yr4(this.a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.a.v().P1() != null && this.a.v().P1().O() != null && !this.a.v().P1().O().isBjh()) {
                arrayList.add(new ur4(0, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1086), yr4Var));
            }
            if (!z2) {
                arrayList.add(new ur4(1, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1087), yr4Var));
            }
            yr4Var.j(arrayList);
            yr4Var.n(new s(this, cVar));
            wr4 wr4Var2 = new wr4(this.a.getPageContext(), yr4Var);
            this.d = wr4Var2;
            wr4Var2.m();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.a.p3();
            wr4 wr4Var = this.b;
            if (wr4Var != null) {
                wr4Var.dismiss();
            }
            K();
        }
    }

    public void G0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            rr4 rr4Var = this.h;
            if (rr4Var != null) {
                rr4Var.d();
                this.h = null;
            }
            if (this.a.v() == null) {
                return;
            }
            ArrayList<as4> arrayList = new ArrayList<>();
            arrayList.add(new as4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0269), "", this.a.v().Y1() == 1, Integer.toString(1)));
            arrayList.add(new as4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b36), "", this.a.v().Y1() == 2, Integer.toString(5)));
            arrayList.add(new as4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b32), "", this.a.v().Y1() == 3, Integer.toString(6)));
            arrayList.add(new as4(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0b50), "", this.a.v().Y1() == 4, Integer.toString(7)));
            rr4 rr4Var2 = new rr4(this.a.getPageContext());
            rr4Var2.l(R.string.obfuscated_res_0x7f0f0dd3);
            this.h = rr4Var2;
            rr4Var2.k(arrayList, onItemClickListener);
            rr4Var2.c();
            this.h.n();
        }
    }

    public void H() {
        wr4 wr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (wr4Var = this.b) == null) {
            return;
        }
        wr4Var.dismiss();
    }

    public void H0(rv7 rv7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, rv7Var) == null) || this.a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.a;
        this.u = new qv7(absVideoPbFragment, absVideoPbFragment.D1);
        AlertDialog create = new AlertDialog.Builder(this.a.getContext(), R.style.obfuscated_res_0x7f100104).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        pg.i(this.t, this.a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = mi.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ee);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.v());
        this.u.N(rv7Var == null ? false : rv7Var.a);
        this.u.A(rv7Var == null ? false : rv7Var.n);
        this.u.C(rv7Var == null ? false : rv7Var.e);
        this.u.H(rv7Var == null ? false : rv7Var.i);
        this.u.D(rv7Var == null ? false : rv7Var.f);
        this.u.P(rv7Var != null ? rv7Var.c : true);
        this.u.M(rv7Var == null ? false : rv7Var.k);
        this.u.E(rv7Var == null ? false : rv7Var.l, rv7Var.t);
        if (rv7Var == null) {
            this.u.K(false, false);
            this.u.I(false, false);
        } else {
            this.u.K(rv7Var.g, rv7Var.s);
            this.u.I(rv7Var.h, rv7Var.r);
        }
        boolean z2 = rv7Var == null ? false : rv7Var.q;
        boolean z3 = rv7Var == null ? false : rv7Var.o;
        boolean z4 = rv7Var == null ? false : rv7Var.d;
        boolean z5 = rv7Var == null ? false : rv7Var.b;
        boolean z6 = rv7Var == null ? false : rv7Var.p;
        boolean z7 = rv7Var == null ? false : rv7Var.j;
        boolean z8 = rv7Var == null ? false : rv7Var.m;
        this.u.F(z4, z3);
        this.u.O(z5, z2);
        this.u.L(z7, z6);
        this.u.S(z8);
        if (rv7Var != null) {
            qv7 qv7Var = this.u;
            boolean z9 = rv7Var.u;
            qv7Var.w = z9;
            if (z9) {
                qv7Var.i().setText(R.string.obfuscated_res_0x7f0f0fc0);
                this.u.D(false);
            }
        }
        this.u.B(rv7Var != null ? rv7Var.v : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.a.v() != null && this.a.v().P1() != null && this.a.v().P1().Q() != null && this.a.v().P1().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.g().setText(R.string.obfuscated_res_0x7f0f081b);
        }
        N0();
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            ng.a().postDelayed(this.I, 100L);
        }
    }

    public final void I0(nr4 nr4Var, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, nr4Var, i2) == null) || (absVideoPbFragment = this.a) == null || nr4Var == null) {
            return;
        }
        if (this.v == null && absVideoPbFragment.getView() != null) {
            this.v = new ri5(this.a.getPageContext(), this.a.getView());
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
        wp4 wp4Var = new wp4();
        wp4Var.j(sparseArray);
        this.v.y(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04b1), this.a.getString(R.string.obfuscated_res_0x7f0f04b2), this.a.getString(R.string.obfuscated_res_0x7f0f04b3), this.a.getString(R.string.obfuscated_res_0x7f0f04b4), this.a.getString(R.string.obfuscated_res_0x7f0f04b5)});
        this.v.x(wp4Var);
        this.v.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.v.z(new h(this, nr4Var));
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (alertDialog = this.t) == null) {
            return;
        }
        pg.a(alertDialog, this.a.getPageContext().getPageActivity());
    }

    public void J0(View view2) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, view2) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.v() == null) {
            return;
        }
        wr4 wr4Var = new wr4(this.a.getPageContext());
        if (this.a.v().P1().f == null || this.a.v().P1().f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11ae), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11af)};
        } else {
            strArr = new String[this.a.v().P1().f.size()];
            for (int i2 = 0; i2 < this.a.v().P1().f.size(); i2++) {
                strArr[i2] = this.a.v().P1().f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11ac);
            }
        }
        wr4Var.j(null, strArr, new m(this, wr4Var, view2));
        wr4Var.m();
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            nr4 nr4Var = this.e;
            if (nr4Var != null) {
                nr4Var.dismiss();
            }
            Dialog dialog = this.f;
            if (dialog != null) {
                pg.b(dialog, this.a.getPageContext());
            }
            Dialog dialog2 = this.g;
            if (dialog2 != null) {
                pg.b(dialog2, this.a.getPageContext());
            }
            wr4 wr4Var = this.q;
            if (wr4Var != null) {
                wr4Var.dismiss();
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
            nr4 nr4Var = new nr4(this.a.getPageContext().getPageActivity());
            nr4Var.setMessage(str);
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0988, new p(this));
            nr4Var.create(this.a.getPageContext()).show();
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
            nr4 nr4Var = new nr4(this.a.getBaseFragmentActivity());
            if (li.isEmpty(str)) {
                nr4Var.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0315, str3));
            } else {
                nr4Var.setMessage(str);
            }
            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0428, new q(this, userMuteAddAndDelCustomMessage));
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new r(this));
            nr4Var.create(this.a.getPageContext()).show();
        }
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            View view2 = this.i;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f09079f);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void M0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.a.v().h2()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(vx7.m(i2))));
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public final void N0() {
        qv7 qv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (qv7Var = this.u) == null) {
            return;
        }
        qv7Var.z();
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

    public qv7 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.u : (qv7) invokeV.objValue;
    }

    public pr4 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.s : (pr4) invokeV.objValue;
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
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091f00) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f00) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091f02) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f02) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f091f01) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091f01) : "";
            String str5 = sparseArray.get(R.id.obfuscated_res_0x7f091efd) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091efd) : "";
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f091efe) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091efe) : "";
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
        ku4 ku4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (ku4Var = this.r) == null) {
            return;
        }
        ku4Var.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.s == null) {
            this.s = new pr4(this.a.getPageContext().getPageActivity());
            String[] strArr = {this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0369), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f11a8), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f10b8)};
            pr4 pr4Var = this.s;
            pr4Var.j(strArr, new l(this));
            pr4Var.g(pr4.b.obfuscated_res_0x7f1003a4);
            pr4Var.h(17);
            pr4Var.c(this.a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? vx7.h(this.a.v()) : invokeV.booleanValue;
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
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eae)) == null) {
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
            PostData U2 = absVideoPbFragment.U2(absVideoPbFragment.v().P1());
            if (U2 != null) {
                J1 = this.a.v().J1(U2);
            }
        }
        if (J1 == null) {
            return;
        }
        this.a.z4();
        if (this.a.c3() != null) {
            this.a.c3().i(J1);
            if (!z2) {
                this.a.c3().a();
            } else {
                this.a.c3().d();
            }
        }
    }

    public void f0(ArrayList<mp4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, arrayList) == null) {
            if (this.i == null) {
                this.i = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01eb, (ViewGroup) null);
            }
            this.a.getBaseFragmentActivity().getLayoutMode().j(this.i);
            if (this.g == null) {
                Dialog dialog = new Dialog(this.a.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f10039f);
                this.g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.g.setCancelable(true);
                this.o = (ScrollView) this.i.findViewById(R.id.obfuscated_res_0x7f090ccc);
                this.g.setContentView(this.i);
                WindowManager.LayoutParams attributes = this.g.getWindow().getAttributes();
                attributes.width = mi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702de);
                this.g.getWindow().setAttributes(attributes);
                this.p = new t(this);
                this.j = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f090ccb);
                TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09079e);
                this.l = textView;
                textView.setOnClickListener(new v(this));
                TextView textView2 = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f09079f);
                this.k = textView2;
                textView2.setOnClickListener(this.a.Z2());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f13c4));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    mp4 mp4Var = arrayList.get(i2);
                    if (mp4Var != null && !TextUtils.isEmpty(mp4Var.b()) && mp4Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(mp4Var.a()), mp4Var.b());
                        this.m.add(D2);
                        View view2 = new View(this.a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, mi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.j.addView(view2);
                        this.j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = mi.d(this.a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = mi.d(this.a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = mi.d(this.a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            pg.j(this.g, this.a.getPageContext());
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
            sparseArray.put(R.id.obfuscated_res_0x7f091eb0, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091eb2, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091ecd, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            int i4 = (i3 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f0492 : R.string.obfuscated_res_0x7f0f0fbd;
            int i5 = R.string.obfuscated_res_0x7f0f0430;
            if (i2 == 0) {
                if (i3 != 1002 || z2) {
                    i5 = R.string.obfuscated_res_0x7f0f0496;
                    i4 = R.string.obfuscated_res_0x7f0f0497;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f0fc1;
                }
            }
            this.e = new nr4(this.a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.e.setMessageId(i4);
            } else {
                this.e.setOnlyMessageShowCenter(false);
                this.e.setMessage(str2);
            }
            this.e.setYesButtonTag(sparseArray);
            this.e.setPositiveButton(R.string.obfuscated_res_0x7f0f04e3, new b(this));
            this.e.setNegativeButton(R.string.obfuscated_res_0x7f0f04de, new c(this));
            this.e.setCancelable(true);
            this.e.create(this.a.getPageContext());
            if (z3) {
                v0(sparseArray, i5, i4);
            } else if (z2) {
                v0(sparseArray, i5, i4);
            } else if (q0()) {
                ti5 ti5Var = new ti5(this.a.v().P1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.v().P1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.v().P1().o().has_forum_rule.intValue());
                ti5Var.i(this.a.v().P1().l().getId(), this.a.v().P1().l().getName());
                ti5Var.h(this.a.v().P1().l().getImage_url());
                ti5Var.j(this.a.v().P1().l().getUser_level());
                C0(sparseArray, i2, ti5Var, this.a.v().P1().U(), false);
            } else {
                I0(this.e, i2);
            }
        }
    }

    public void j0(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091eb0, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091eb2, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091ecd, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(z2));
            sparseArray.put(Q, Integer.valueOf(R));
            if (z2) {
                r0(sparseArray);
            } else {
                s0(i2, sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z2) {
        ur4 ur4Var;
        ur4 ur4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048625, this, sparseArray, z2) == null) {
            yr4 yr4Var = new yr4(this.a.getContext());
            yr4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02d9));
            yr4Var.n(new j(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091eb0)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091eb2) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091eb2)).intValue() : -1) == 0) {
                    ur4Var2 = new ur4(10, this.a.getString(R.string.obfuscated_res_0x7f0f04a8), yr4Var);
                } else {
                    ur4Var2 = new ur4(10, this.a.getString(R.string.obfuscated_res_0x7f0f049d), yr4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091eb0, sparseArray.get(R.id.obfuscated_res_0x7f091eb0));
                sparseArray2.put(R.id.obfuscated_res_0x7f091eb2, sparseArray.get(R.id.obfuscated_res_0x7f091eb2));
                sparseArray2.put(R.id.obfuscated_res_0x7f091eb1, sparseArray.get(R.id.obfuscated_res_0x7f091eb1));
                sparseArray2.put(R.id.obfuscated_res_0x7f091ecd, sparseArray.get(R.id.obfuscated_res_0x7f091ecd));
                ur4Var2.d.setTag(sparseArray2);
                arrayList.add(ur4Var2);
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ebb)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ebc))) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                sparseArray3.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                sparseArray3.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                sparseArray3.put(R.id.obfuscated_res_0x7f091ecd, sparseArray.get(R.id.obfuscated_res_0x7f091ecd));
                sparseArray3.put(R.id.obfuscated_res_0x7f091ebe, sparseArray.get(R.id.obfuscated_res_0x7f091ebe));
                ur4 ur4Var3 = new ur4(11, this.a.getString(R.string.obfuscated_res_0x7f0f0645), yr4Var);
                ur4Var3.d.setTag(sparseArray3);
                arrayList.add(ur4Var3);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f091f03) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f03)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091ec5, sparseArray.get(R.id.obfuscated_res_0x7f091ec5));
                sparseArray4.put(R.id.obfuscated_res_0x7f091eff, sparseArray.get(R.id.obfuscated_res_0x7f091eff));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f00, sparseArray.get(R.id.obfuscated_res_0x7f091f00));
                sparseArray4.put(R.id.obfuscated_res_0x7f091efe, sparseArray.get(R.id.obfuscated_res_0x7f091efe));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f02, sparseArray.get(R.id.obfuscated_res_0x7f091f02));
                sparseArray4.put(R.id.obfuscated_res_0x7f091efd, sparseArray.get(R.id.obfuscated_res_0x7f091efd));
                if (z2) {
                    ur4Var = new ur4(12, this.a.getString(R.string.obfuscated_res_0x7f0f148f), yr4Var);
                } else {
                    ur4Var = new ur4(12, this.a.getString(R.string.obfuscated_res_0x7f0f0b25), yr4Var);
                }
                ur4Var.d.setTag(sparseArray4);
                arrayList.add(ur4Var);
            }
            yr4Var.j(arrayList);
            wr4 wr4Var = this.q;
            if (wr4Var == null) {
                this.q = new wr4(this.a.getPageContext(), yr4Var);
            } else {
                wr4Var.i(yr4Var);
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
        bs7 P1;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.v() == null || this.a.v().P1() == null || (O = (P1 = this.a.v().P1()).O()) == null || O.getAuthor() == null) {
            return;
        }
        this.a.p3();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), O.getAuthor().getUserId());
        rv7 rv7Var = new rv7();
        int V = this.a.v().P1().V();
        boolean z2 = true;
        if (V != 1 && V != 3) {
            rv7Var.g = false;
        } else {
            rv7Var.g = true;
            rv7Var.s = O.getIs_top() == 1;
        }
        if (Z(V)) {
            rv7Var.h = true;
            rv7Var.r = O.getIs_good() == 1;
        } else {
            rv7Var.h = false;
        }
        if (V == 1002 && !equals) {
            rv7Var.u = true;
        }
        rv7Var.n = y0(O.isBlocked(), P1.i0(), equals, V, O.isWorksInfo(), O.isScoreThread());
        rv7Var.e = u0(equals, P1.i0());
        rv7Var.i = z0();
        rv7Var.f = x0(equals);
        rv7Var.k = equals && P1.U() != null && P1.U().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            rv7Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().isSwitchOpen();
        }
        rv7Var.t = equals;
        rv7Var.q = this.a.v().f2();
        rv7Var.b = true;
        rv7Var.a = b0(equals);
        rv7Var.p = TbadkCoreApplication.getInst().getSkinType() == 1;
        rv7Var.j = true;
        rv7Var.o = this.a.v().s1();
        rv7Var.d = true;
        if (O.getThreadVideoInfo() == null) {
            rv7Var.c = true;
        } else {
            rv7Var.c = false;
        }
        if (P1.g0()) {
            rv7Var.b = false;
            rv7Var.d = false;
            rv7Var.c = false;
            rv7Var.g = false;
            rv7Var.h = false;
        }
        rv7Var.v = (TbSingleton.getInstance().mShowCallFans && equals && !P1.g0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.a;
        if (absVideoPbFragment2.U2(absVideoPbFragment2.v().P1()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.a;
            rv7Var.w = absVideoPbFragment3.U2(absVideoPbFragment3.v().P1()).Q;
        }
        if (O.isBlocked()) {
            rv7Var.n = false;
            rv7Var.g = false;
            rv7Var.h = false;
        }
        H0(rv7Var);
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
        sparseArray.put(R.id.obfuscated_res_0x7f091757, Integer.valueOf(this.O ? 2 : 3));
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
            sparseArray.put(R.id.obfuscated_res_0x7f091ec4, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1175, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0374, TBAlertConfig.OperateBtnStyle.SECONDARY);
        bs4 bs4Var = new bs4(this.a.w());
        bs4Var.v(R.string.obfuscated_res_0x7f0f0b21);
        bs4Var.l(R.string.obfuscated_res_0x7f0f0b22);
        bs4Var.n(true);
        bs4Var.r(aVar2, aVar);
        bs4Var.i(false);
        androidx.appcompat.app.AlertDialog y2 = bs4Var.y();
        aVar.a(new f(this, y2, sparseArray));
        aVar2.a(new g(this, y2));
    }

    public final void s0(int i2, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048633, this, i2, sparseArray) == null) || this.a == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f091ec4, Boolean.TRUE);
        }
        ti5 ti5Var = new ti5(this.a.v().P1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.a.v().P1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.a.v().P1().o().has_forum_rule.intValue());
        ti5Var.i(this.a.v().P1().l().getId(), this.a.v().P1().l().getName());
        ti5Var.h(this.a.v().P1().l().getImage_url());
        ti5Var.j(this.a.v().P1().l().getUser_level());
        C0(sparseArray, i2, ti5Var, this.a.v().P1().U(), true);
    }

    public final void t0(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            vx7.d(this.a.getActivity(), this.a.getPageContext(), new y(this, sparseArray, i2, z2), new z(this));
        }
    }

    public final boolean u0(boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        ep4 ep4Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.a;
            if (absVideoPbFragment == null || absVideoPbFragment.v() == null || this.a.v().P1() == null) {
                return false;
            }
            bs7 P1 = this.a.v().P1();
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
            if ((O != null && O.getAuthor() != null && O.getAuthor().isForumBusinessAccount() && !be6.isOn()) || this.a.v().G() || O.isWorksInfo() || O.isScoreThread() || z3) {
                return false;
            }
            if (P1.l() == null || !P1.l().isBlockBawuDelete) {
                if (P1.O() == null || !P1.O().isBlocked()) {
                    if (P1.V() != 0) {
                        return P1.V() != 3;
                    }
                    List<yq4> p2 = P1.p();
                    if (ListUtils.getCount(p2) > 0) {
                        for (yq4 yq4Var : p2) {
                            if (yq4Var != null && (ep4Var = yq4Var.g) != null && ep4Var.a && !ep4Var.c && ((i2 = ep4Var.b) == 1 || i2 == 2)) {
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
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f049d, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0374, TBAlertConfig.OperateBtnStyle.SECONDARY);
        bs4 bs4Var = new bs4(this.a.w());
        bs4Var.v(i2);
        bs4Var.l(i3);
        bs4Var.n(true);
        bs4Var.r(aVar2, aVar);
        bs4Var.i(false);
        androidx.appcompat.app.AlertDialog y2 = bs4Var.y();
        aVar.a(new d(this, y2, sparseArray));
        aVar2.a(new e(this, y2));
    }

    public void w0(SparseArray<Object> sparseArray) {
        AbsVideoPbFragment absVideoPbFragment;
        PostData postData;
        ur4 ur4Var;
        ur4 ur4Var2;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, sparseArray) == null) || (absVideoPbFragment = this.a) == null || absVideoPbFragment.v() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eae)) == null) {
            return;
        }
        if (this.c == null) {
            yr4 yr4Var = new yr4(this.a.getContext());
            this.c = yr4Var;
            yr4Var.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z2 = this.a.v().P1() != null && this.a.v().P1().g0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091eb1) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eb1)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091f03) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f03)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091ef0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef0)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.obfuscated_res_0x7f091f03) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f03)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.obfuscated_res_0x7f091eee) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eee)).booleanValue() : false;
            ur4 ur4Var3 = null;
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ebe) : null;
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
                ur4 ur4Var4 = new ur4(8, absVideoPbFragment2.getString(i2), this.c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091eae, postData);
                ur4Var4.d.setTag(sparseArray2);
                arrayList.add(ur4Var4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    ur4 ur4Var5 = new ur4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0b29), this.c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f03, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ec5, sparseArray.get(R.id.obfuscated_res_0x7f091ec5));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eff, sparseArray.get(R.id.obfuscated_res_0x7f091eff));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f00, sparseArray.get(R.id.obfuscated_res_0x7f091f00));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091efe, sparseArray.get(R.id.obfuscated_res_0x7f091efe));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091f02, sparseArray.get(R.id.obfuscated_res_0x7f091f02));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eb1, sparseArray.get(R.id.obfuscated_res_0x7f091eb1));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eb2, sparseArray.get(R.id.obfuscated_res_0x7f091eb2));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091eb0, sparseArray.get(R.id.obfuscated_res_0x7f091eb0));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ecd, sparseArray.get(R.id.obfuscated_res_0x7f091ecd));
                    ur4Var5.d.setTag(sparseArray3);
                    arrayList.add(ur4Var5);
                } else {
                    if ((b0(booleanValue) && TbadkCoreApplication.isLogin()) && !z2) {
                        ur4 ur4Var6 = new ur4(5, this.a.getString(R.string.obfuscated_res_0x7f0f0fc0), this.c);
                        ur4Var6.d.setTag(str);
                        arrayList.add(ur4Var6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ef0, Boolean.TRUE);
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ecd, sparseArray.get(R.id.obfuscated_res_0x7f091ecd));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ebb, sparseArray.get(R.id.obfuscated_res_0x7f091ebb));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ebc, sparseArray.get(R.id.obfuscated_res_0x7f091ebc));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ebd, sparseArray.get(R.id.obfuscated_res_0x7f091ebd));
                    sparseArray4.put(R.id.obfuscated_res_0x7f091ebe, str);
                    if (booleanValue4) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f03, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ec5, sparseArray.get(R.id.obfuscated_res_0x7f091ec5));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eff, sparseArray.get(R.id.obfuscated_res_0x7f091eff));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f00, sparseArray.get(R.id.obfuscated_res_0x7f091f00));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091efe, sparseArray.get(R.id.obfuscated_res_0x7f091efe));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f02, sparseArray.get(R.id.obfuscated_res_0x7f091f02));
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091f03, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eee, Boolean.TRUE);
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(booleanValue));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eb0, sparseArray.get(R.id.obfuscated_res_0x7f091eb0));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eb2, sparseArray.get(R.id.obfuscated_res_0x7f091eb2));
                        sparseArray4.put(R.id.obfuscated_res_0x7f091ec2, sparseArray.get(R.id.obfuscated_res_0x7f091ec2));
                        ur4 ur4Var7 = new ur4(6, this.a.getString(R.string.obfuscated_res_0x7f0f049d), this.c);
                        ur4Var7.d.setTag(sparseArray4);
                        ur4Var3 = ur4Var7;
                    } else {
                        sparseArray4.put(R.id.obfuscated_res_0x7f091eee, Boolean.FALSE);
                    }
                    ur4 ur4Var8 = new ur4(7, this.a.getString(R.string.obfuscated_res_0x7f0f02d9), this.c);
                    ur4Var8.d.setTag(sparseArray4);
                    ur4Var2 = ur4Var8;
                    ur4Var = ur4Var3;
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ef0, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091f03, Boolean.FALSE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eee, Boolean.TRUE);
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ecd, sparseArray.get(R.id.obfuscated_res_0x7f091ecd));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eb1, Boolean.valueOf(booleanValue));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eb0, sparseArray.get(R.id.obfuscated_res_0x7f091eb0));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091eb2, sparseArray.get(R.id.obfuscated_res_0x7f091eb2));
                    sparseArray5.put(R.id.obfuscated_res_0x7f091ec2, sparseArray.get(R.id.obfuscated_res_0x7f091ec2));
                    if (this.a.v().P1().V() == 1002 && !booleanValue) {
                        ur4Var = new ur4(6, this.a.getString(R.string.obfuscated_res_0x7f0f0fc0), this.c);
                    } else {
                        ur4Var = new ur4(6, this.a.getString(R.string.obfuscated_res_0x7f0f049d), this.c);
                    }
                    ur4Var.d.setTag(sparseArray5);
                    ur4Var2 = null;
                } else {
                    ur4Var = null;
                    ur4Var2 = null;
                }
                if (ur4Var != null) {
                    arrayList.add(ur4Var);
                }
                if (ur4Var2 != null) {
                    arrayList.add(ur4Var2);
                }
                if (!booleanValue) {
                    arrayList.add(new ur4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0316), this.c));
                }
            }
            this.c.j(arrayList);
            wr4 wr4Var = new wr4(this.a.getPageContext(), this.c);
            this.b = wr4Var;
            wr4Var.m();
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
            bs7 P1 = this.a.v().P1();
            if ((P1.O() == null || P1.O().getAuthor() == null || !P1.O().getAuthor().isForumBusinessAccount() || be6.isOn()) && !this.a.v().G()) {
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
