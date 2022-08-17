package com.repackage;

import android.app.Activity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bl5;
import com.repackage.fs4;
import com.repackage.ur4;
import com.repackage.yk5;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class dv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView A;
    public View B;
    public View.OnClickListener C;
    public View.OnClickListener D;
    public TbRichTextView.y E;
    public gu7 F;
    public View.OnLongClickListener G;
    public ds4 H;
    public ur4 I;
    public int J;
    public PbFragment.h3 K;
    public uu4 L;
    public yk5 M;
    public bl5 N;
    public String O;
    public PermissionJudgePolicy P;
    public boolean Q;
    public TextView R;
    public PbEmotionBar S;
    public EditorTools T;
    public gw7 U;
    public List<String> V;
    public ky7 W;
    public PbFakeFloorModel X;
    public BdListView.p Y;
    public CustomMessageListener Z;
    public FoldCommentActivity a;
    public PbModel b;
    public NoNetworkView c;
    public NoDataView d;
    public SubPbView e;
    public LinearLayout f;
    public NavigationBar g;
    public ImageView h;
    public View i;
    public View j;
    public ImageView k;
    public AlertDialog l;
    public BlankView m;
    public RelativeLayout n;
    public BdTypeListView o;
    public sz7 p;
    public ProgressBar q;
    public bv7 r;
    public et7 s;
    public boolean t;
    public MaskView u;
    public TextView v;
    public ImageView w;
    public ImageView x;
    public RelativeLayout y;
    public LinearLayout z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        public a(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f09202e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09202e)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ffb, 1);
                    this.a.a.K1(sparseArray);
                    return;
                }
                this.a.P(view2);
            } else if (booleanValue2) {
                sparseArray.put(R.id.obfuscated_res_0x7f091ffb, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091fe4, 1);
                this.a.a.K1(sparseArray);
            } else if (booleanValue3) {
                this.a.L(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fea), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        public b(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null) {
                return;
            }
            this.a.b.T2();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ dv7 b;

        public c(dv7 dv7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dv7Var;
            this.a = z;
        }

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                this.b.H.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.L(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fea), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
                        return;
                    case 11:
                        if (this.b.K != null) {
                            this.b.K.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f092008), sparseArray.get(R.id.obfuscated_res_0x7f091ff5), sparseArray.get(R.id.obfuscated_res_0x7f091ff8), sparseArray.get(R.id.obfuscated_res_0x7f091ff6), sparseArray.get(R.id.obfuscated_res_0x7f091ff7)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.a.h2(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f092040), sparseArray);
                        return;
                    case 13:
                        this.b.i0(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
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
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ dv7 c;

        public e(dv7 dv7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dv7Var;
            this.a = alertDialog;
            this.b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!oi.A()) {
                    qi.M(this.c.a, R.string.obfuscated_res_0x7f0f0c3d);
                } else {
                    this.c.a.Q1(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public f(dv7 dv7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var, alertDialog};
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
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class g implements bl5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ dv7 b;

        public g(dv7 dv7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dv7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.bl5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.Q1(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements yk5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur4 a;
        public final /* synthetic */ dv7 b;

        public h(dv7 dv7Var, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var, ur4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dv7Var;
            this.a = ur4Var;
        }

        @Override // com.repackage.yk5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.a.R1(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        public i(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.R();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements i25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        public j(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // com.repackage.i25
        public void A(h25 h25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h25Var) == null) {
                Object obj = h25Var.c;
                if ((obj instanceof gy4) && EmotionGroupType.isSendAsPic(((gy4) obj).getType())) {
                    if (this.a.P == null) {
                        this.a.P = new PermissionJudgePolicy();
                    }
                    this.a.P.clearRequestPermissionList();
                    this.a.P.appendRequestPermission(this.a.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.P.startRequestPermission(this.a.a)) {
                        return;
                    }
                    this.a.a.d2().h((gy4) h25Var.c);
                    this.a.a.d2().z(false, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        public k(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.J();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        public l(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.a.s == null || this.a.a.s.e() == null) {
                return;
            }
            if (!this.a.a.s.e().e()) {
                this.a.a.s.a(false);
            }
            this.a.a.s.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || this.a.T == null || this.a.T.getVisibility() != 0 || charSequence == null || charSequence.length() < (i4 = i3 + i)) {
                return;
            }
            String substring = charSequence.toString().substring(i, i4);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.a.W == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.a.T.getId());
                dv7 dv7Var = this.a;
                dv7Var.W = new ky7(dv7Var.a.getPageContext(), this.a.e, layoutParams);
                if (!ListUtils.isEmpty(this.a.V)) {
                    this.a.W.q(this.a.V);
                }
                this.a.W.r(this.a.T);
            }
            this.a.W.p(substring);
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(dv7 dv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof vt7)) {
                vt7 vt7Var = (vt7) customResponsedMessage.getData();
                if (this.a.e != null) {
                    this.a.e.setSubPbViewData(vt7Var);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        public n(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.J();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        public o(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                this.a.a.x2();
                if (this.a.a == null || this.a.a.a2() == null || this.a.a.a2().S1() == null || this.a.a.a2().S1().O() == null || this.a.a.a2().S1().O().getAuthor() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.a.a2().n2()).param("fid", this.a.a.a2().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.a.a2().m2()).param("fid", this.a.a.a2().S1().m()).param("obj_locate", 1).param("uid", this.a.a.a2().S1().O().getAuthor().getUserId()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        public p(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.R();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        public q(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.X.Q(postData);
                this.a.r.b();
                this.a.U.c();
                this.a.T.q();
                this.a.a0(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        public r(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e == null) {
                return;
            }
            this.a.e.g();
        }
    }

    /* loaded from: classes6.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        public s(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t a;

            public a(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a.l == null) {
                    return;
                }
                this.a.a.l.dismiss();
            }
        }

        /* loaded from: classes6.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ t a;

            public b(t tVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {tVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_COMMUNITY_CONVENTION_CLICK).addParam("obj_locate", "3").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
                    UrlManager.getInstance().dealOneLink(this.a.a.a.getPageContext(), new String[]{TbConfig.COMMUNITY_CONVENTION});
                    if (this.a.a.s != null) {
                        TiebaStatic.log(new StatisticItem("c14445").param("tid", this.a.a.s.Q()).param("fname", this.a.a.s.n()).param("fid", this.a.a.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                }
            }
        }

        public t(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SpannableString spannableString = new SpannableString(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f040a));
                if (this.a.s != null) {
                    TiebaStatic.log(new StatisticItem("c14444").param("tid", this.a.s.Q()).param("fname", this.a.s.n()).param("fid", this.a.s.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f09a1, TBAlertConfig.OperateBtnStyle.MAIN);
                aVar.a(new a(this));
                LinearLayout linearLayout = new LinearLayout(this.a.a);
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                linearLayout.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X008), 0, 0);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                TextView textView = new TextView(this.a.a);
                textView.setText(R.string.obfuscated_res_0x7f0f154b);
                textView.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X07));
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0304));
                textView.setOnClickListener(new b(this));
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
                ImageView imageView = new ImageView(this.a.a);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS));
                linearLayout.addView(imageView, new LinearLayout.LayoutParams(qi.f(this.a.a, R.dimen.tbds36), qi.f(this.a.a, R.dimen.tbds36)));
                dv7 dv7Var = this.a;
                TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(dv7Var.a);
                tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0409);
                tBAlertBuilder.o(spannableString);
                tBAlertBuilder.l(3);
                tBAlertBuilder.i(linearLayout);
                tBAlertBuilder.m(true);
                tBAlertBuilder.n(LinkMovementMethod.getInstance());
                tBAlertBuilder.r(aVar);
                tBAlertBuilder.h(true);
                dv7Var.l = tBAlertBuilder.w();
            }
        }
    }

    public dv7(FoldCommentActivity foldCommentActivity, View.OnClickListener onClickListener, TbRichTextView.y yVar, gu7 gu7Var, View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {foldCommentActivity, onClickListener, yVar, gu7Var, onLongClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.q = null;
        this.H = null;
        this.I = null;
        this.J = 0;
        this.L = null;
        this.Q = false;
        this.Y = new k(this);
        this.Z = new m(this, 2921597);
        this.a = foldCommentActivity;
        this.b = foldCommentActivity.a2();
        this.C = onClickListener;
        this.E = yVar;
        this.F = gu7Var;
        this.G = onLongClickListener;
        SubPbView subPbView = (SubPbView) LayoutInflater.from(foldCommentActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0494, (ViewGroup) null);
        this.e = subPbView;
        this.f = (LinearLayout) subPbView.findViewById(R.id.obfuscated_res_0x7f091627);
        RelativeLayout relativeLayout = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090a04);
        this.y = relativeLayout;
        relativeLayout.setVisibility(8);
        this.v = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f090a05);
        this.w = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090a08);
        this.x = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090a07);
        this.c = (NoNetworkView) this.e.findViewById(R.id.obfuscated_res_0x7f09255e);
        G();
        this.n = (RelativeLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090a02);
        this.o = (BdTypeListView) this.e.findViewById(R.id.obfuscated_res_0x7f090a09);
        View view2 = new View(foldCommentActivity.getActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, 16));
        this.o.x(view2, 0);
        this.o.setOnSrollToBottomListener(this.Y);
        this.e.setTopView(view2);
        this.e.setNavigationView(this.f);
        this.e.setListView(this.o);
        this.e.setContentView(this.n);
        sz7 sz7Var = new sz7(foldCommentActivity.getPageContext());
        this.p = sz7Var;
        sz7Var.x();
        this.p.B(new n(this));
        this.o.setNextPage(this.p);
        this.q = (ProgressBar) this.e.findViewById(R.id.obfuscated_res_0x7f091a78);
        this.u = (MaskView) this.e.findViewById(R.id.obfuscated_res_0x7f0914a0);
        this.B = this.e.findViewById(R.id.obfuscated_res_0x7f092544);
        LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090a03);
        this.z = linearLayout;
        linearLayout.setOnClickListener(new o(this));
        HeadImageView headImageView = (HeadImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090a06);
        this.A = headImageView;
        headImageView.setVisibility(0);
        this.A.setIsRound(true);
        this.A.setBorderWidth(qi.f(this.a, R.dimen.L_X01));
        this.A.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.A.setDefaultBgResource(0);
        this.A.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.A.K(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        K(TbadkCoreApplication.getInst().getSkinType());
        F();
        PbFakeFloorModel pbFakeFloorModel = new PbFakeFloorModel(this.a.getPageContext());
        this.X = pbFakeFloorModel;
        pbFakeFloorModel.S(this.b.I(), this.b.E(), this.b.F(), this.b.D(), this.b.J());
        gw7 gw7Var = new gw7(this.a.getPageContext(), this.X, this.n);
        this.U = gw7Var;
        gw7Var.k(new p(this));
        this.U.n(this.a.W);
        this.X.U(new q(this));
        this.a.registerListener(this.Z);
    }

    public SubPbView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (SubPbView) invokeV.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.y == null) {
            return;
        }
        this.B.setVisibility(8);
        this.y.setVisibility(8);
        PbEmotionBar pbEmotionBar = this.S;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.y == null || this.R == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        PbModel pbModel = this.b;
        boolean z2 = true;
        this.R.setText(tbSingleton.getAdVertiComment((pbModel == null || pbModel.S1() == null || !this.b.S1().n0()) ? false : true, (this.b.S1() == null || !this.b.S1().o0()) ? false : false, z()));
        if (z) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.y.startAnimation(alphaAnimation);
        }
    }

    public void D() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (editorTools = this.T) == null) {
            return;
        }
        editorTools.o();
        ky7 ky7Var = this.W;
        if (ky7Var != null) {
            ky7Var.m();
        }
    }

    public void E() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (noDataView = this.d) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.o.setVisibility(0);
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            bv7 bv7Var = new bv7(this.a, this.o);
            this.r = bv7Var;
            bv7Var.j(this.a.z0());
            this.r.k(this.a.e2());
            this.r.g(this.E);
            this.r.c(this.C);
            this.r.l(this.F);
            this.r.g(this.E);
            this.r.h(this.G);
            a aVar = new a(this);
            this.D = aVar;
            this.r.e(aVar);
            this.r.a();
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int f2 = qi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070306);
            int f3 = qi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d4);
            NavigationBar navigationBar = (NavigationBar) this.e.findViewById(R.id.obfuscated_res_0x7f09255c);
            this.g = navigationBar;
            navigationBar.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0641));
            this.i = this.g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0495, (ViewGroup) null);
            this.j = linearLayout;
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091631);
            this.k = imageView;
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080930, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.j, new t(this));
            ImageView backImageView = this.g.getBackImageView();
            this.h = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams.height = f2;
                layoutParams.width = f2;
                layoutParams.leftMargin = f3;
                backImageView.setLayoutParams(layoutParams);
            }
            View view2 = this.i;
            if (view2 != null && (view2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams2.width = f2;
                layoutParams2.height = f2;
                this.i.setLayoutParams(layoutParams2);
            }
            this.g.setIsClose(true);
            this.g.setIsCorner(true);
            this.g.isShowBottomLine(true);
            this.g.setBottomLineHeight(3);
            this.g.setStatusBarVisibility(8);
        }
    }

    public final void H(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fb9), new b(this)));
            if (this.d == null) {
                Activity pageActivity = this.a.getPageContext().getPageActivity();
                this.d = NoDataViewFactory.a(pageActivity, this.n, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, qi.f(pageActivity, R.dimen.obfuscated_res_0x7f070288)), eVar, a2);
            }
            this.o.setVisibility(8);
            this.q.setVisibility(8);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            this.d.setClickable(true);
            this.d.setTextOption(eVar);
            this.d.f(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.d.setVisibility(0);
        }
    }

    public void I() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a == null || (editorTools = this.T) == null) {
            return;
        }
        editorTools.j();
        if (this.a.d2() != null) {
            this.a.d2().Q();
        }
        B();
    }

    public final void J() {
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (pbModel = this.b) == null || pbModel.S1() == null || this.b.S1().y() == null || !qi.D()) {
            return;
        }
        if (this.b.S1().y().b() == 0) {
            U();
            return;
        }
        sz7 sz7Var = this.p;
        if (sz7Var != null) {
            sz7Var.Q();
        }
        if (this.b.N2(false)) {
            X();
        } else {
            U();
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.a.getLayoutMode().l(i2 == 1);
            this.a.getLayoutMode().k(this.e);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            this.g.onChangeSkinType(this.a.getPageContext(), i2);
            PbModel pbModel = this.b;
            if (pbModel != null && (pbModel.C2() || this.b.B2())) {
                WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f080ac5, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.h, R.drawable.obfuscated_res_0x7f0809f3, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            this.c.d(this.a.getPageContext(), i2);
            this.a.getLayoutMode().k(this.p.b());
            this.p.d(i2);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0110);
            this.v.setAlpha(0.95f);
            bv7 bv7Var = this.r;
            if (bv7Var != null) {
                bv7Var.b();
            }
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0203);
            this.A.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.z.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(qi.f(this.a, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            ms4.d(this.y).f(R.color.CAM_X0208);
        }
    }

    public void L(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            M(i2, str, i3, z, null);
        }
    }

    public void M(int i2, String str, int i3, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), str2}) == null) {
            N(i2, str, i3, z, str2, false);
        }
    }

    public void N(int i2, String str, int i3, boolean z, String str2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), str2, Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fea, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z));
            sparseArray.put(0, 3);
            int i4 = (i3 != 1002 || z) ? R.string.obfuscated_res_0x7f0f04a0 : R.string.obfuscated_res_0x7f0f0ff4;
            int i5 = R.string.obfuscated_res_0x7f0f0439;
            if (i2 == 0) {
                if (i3 != 1002 || z) {
                    i5 = R.string.obfuscated_res_0x7f0f04a4;
                    i4 = R.string.obfuscated_res_0x7f0f04a5;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f0ff8;
                }
            }
            this.I = new ur4(this.a);
            if (StringUtils.isNull(str2)) {
                this.I.setMessageId(i4);
            } else {
                this.I.setOnlyMessageShowCenter(false);
                this.I.setMessage(str2);
            }
            this.I.setYesButtonTag(sparseArray);
            this.I.setPositiveButton(R.string.obfuscated_res_0x7f0f04ee, this.a);
            this.I.setNegativeButton(R.string.obfuscated_res_0x7f0f04e9, new d(this));
            this.I.setCancelable(true);
            this.I.create(this.a.getPageContext());
            if (z2) {
                b0(sparseArray, i5, i4);
            } else if (z) {
                b0(sparseArray, i5, i4);
            } else if (Z()) {
                al5 al5Var = new al5(this.b.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.b.S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.b.S1().o().has_forum_rule.intValue());
                al5Var.i(this.b.S1().l().getId(), this.b.S1().l().getName());
                al5Var.h(this.b.S1().l().getImage_url());
                al5Var.j(this.b.S1().l().getUser_level());
                e0(sparseArray, i2, al5Var, this.b.S1().V(), false);
            } else {
                h0(this.I, i2);
            }
        }
    }

    public void O(SparseArray<Object> sparseArray, boolean z) {
        bs4 bs4Var;
        bs4 bs4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, sparseArray, z) == null) {
            fs4 fs4Var = new fs4(this.a);
            fs4Var.q(this.a.getString(R.string.obfuscated_res_0x7f0f02e3));
            fs4Var.n(new c(this, z));
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
                if (z) {
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
            ds4 ds4Var = new ds4(this.a.getPageContext(), fs4Var);
            this.H = ds4Var;
            ds4Var.k();
        }
    }

    public void P(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        O(sparseArray, false);
    }

    public final void Q() {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (foldCommentActivity = this.a) == null || foldCommentActivity.d2() == null || this.T == null) {
            return;
        }
        g45.a().c(0);
        k45 d2 = this.a.d2();
        d2.U();
        d2.S();
        if (d2.y() != null) {
            d2.y().setMaxImagesAllowed(d2.v ? 1 : 9);
        }
        d2.n0(SendView.h);
        d2.j(SendView.h);
        o25 m2 = this.T.m(23);
        o25 m3 = this.T.m(2);
        o25 m4 = this.T.m(5);
        if (m3 != null) {
            m3.display();
        }
        if (m4 != null) {
            m4.display();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.T.invalidate();
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Q();
            D();
            this.U.c();
            a0(false);
        }
    }

    public void S(et7 et7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048594, this, et7Var, z) == null) || et7Var == null) {
            return;
        }
        this.s = et7Var;
        this.t = z;
        if (et7Var.b0()) {
            this.p.Q();
        } else {
            this.p.f();
        }
        this.r.d(this.t);
        this.r.i(et7Var);
        this.e.setEnableDragExit(true);
        String adVertiComment = TbSingleton.getInstance().getAdVertiComment(et7Var.n0(), et7Var.o0(), z());
        TextView textView = this.R;
        if (textView != null) {
            textView.setText(adVertiComment);
        }
    }

    public void T(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, editorTools) == null) {
            this.T = editorTools;
            editorTools.setOnCancelClickListener(new i(this));
            this.T.setId(R.id.obfuscated_res_0x7f0917bb);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.T.getParent() == null) {
                this.n.addView(this.T, layoutParams);
            }
            this.T.w(TbadkCoreApplication.getInst().getSkinType());
            this.T.setActionListener(24, new j(this));
            D();
            this.a.d2().i(new l(this));
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.o.setVisibility(0);
            this.q.setVisibility(8);
            this.p.f();
        }
    }

    public void V(PbFragment.h3 h3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, h3Var) == null) {
            this.K = h3Var;
        }
    }

    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.Q = z;
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.o.setVisibility(0);
            this.q.setVisibility(8);
            this.p.R();
        }
    }

    public void Y(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, pbModel) == null) {
            this.b = pbModel;
        }
    }

    public final boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? (this.a == null || this.b.S1().l().getDeletedReasonInfo() == null || 1 != this.b.S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true : invokeV.booleanValue;
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || this.y == null) {
            return;
        }
        W(this.a.d2().C());
        if (this.Q) {
            c0(z);
        } else {
            C(z);
        }
    }

    public final void b0(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048603, this, sparseArray, i2, i3) == null) || this.a == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04ab, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0370, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a);
        tBAlertBuilder.t(i2);
        tBAlertBuilder.k(i3);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        AlertDialog w = tBAlertBuilder.w();
        aVar.a(new e(this, w, sparseArray));
        aVar2.a(new f(this, w));
    }

    public void c0(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || this.y == null || (textView = this.R) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0519);
        if (z) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.y.startAnimation(alphaAnimation);
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.L == null) {
                this.L = new uu4(this.a.getPageContext());
            }
            this.L.h(true);
        }
    }

    public final void e0(SparseArray<Object> sparseArray, int i2, al5 al5Var, UserData userData, boolean z) {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{sparseArray, Integer.valueOf(i2), al5Var, userData, Boolean.valueOf(z)}) == null) || (foldCommentActivity = this.a) == null) {
            return;
        }
        if (this.N == null) {
            this.N = new bl5(foldCommentActivity.getPageContext(), null, al5Var, userData);
        }
        this.N.C(z);
        AntiData U1 = this.a.U1();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (U1 != null && U1.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = U1.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        cq4 cq4Var = new cq4();
        cq4Var.j(sparseArray2);
        this.N.E(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04bf), this.a.getString(R.string.obfuscated_res_0x7f0f04c0), this.a.getString(R.string.obfuscated_res_0x7f0f04c1), this.a.getString(R.string.obfuscated_res_0x7f0f04c2), this.a.getString(R.string.obfuscated_res_0x7f0f04c3)});
        this.N.D(cq4Var);
        this.N.G((i2 == 1 || i2 == 2) ? "4" : "3");
        this.N.F(new g(this, sparseArray));
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            H(NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fba)));
            this.y.setVisibility(8);
        }
    }

    public void g0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, str, z) == null) {
            if (z) {
                H(NoDataViewFactory.e.d("", str));
            } else {
                H(NoDataViewFactory.e.d(str, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fba)));
            }
            this.y.setVisibility(8);
        }
    }

    public final void h0(ur4 ur4Var, int i2) {
        FoldCommentActivity foldCommentActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048609, this, ur4Var, i2) == null) || (foldCommentActivity = this.a) == null || ur4Var == null) {
            return;
        }
        if (this.M == null) {
            this.M = new yk5(foldCommentActivity.getPageContext(), null);
        }
        AntiData U1 = this.a.U1();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (U1 != null && U1.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = U1.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        cq4 cq4Var = new cq4();
        cq4Var.j(sparseArray);
        this.M.y(new String[]{this.a.getString(R.string.obfuscated_res_0x7f0f04bf), this.a.getString(R.string.obfuscated_res_0x7f0f04c0), this.a.getString(R.string.obfuscated_res_0x7f0f04c1), this.a.getString(R.string.obfuscated_res_0x7f0f04c2), this.a.getString(R.string.obfuscated_res_0x7f0f04c3)});
        this.M.x(cq4Var);
        this.M.A((i2 == 1 || i2 == 2) ? "4" : "3");
        this.M.z(new h(this, ur4Var));
    }

    public void i0(boolean z) {
        bv7 bv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z) == null) || (bv7Var = this.r) == null) {
            return;
        }
        bv7Var.f(z);
        this.r.b();
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.m = new BlankView(this.a.getPageContext().getPageActivity());
            PbModel pbModel = this.b;
            if (pbModel != null && (pbModel.C2() || this.b.B2())) {
                this.J = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds562) + UtilHelper.getStatusBarHeight();
            } else {
                this.J = qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070252);
            }
            this.f.addView(this.m, 0, new LinearLayout.LayoutParams(-1, this.J));
            this.m.setVisibility(0);
            this.m.setOnClickListener(new r(this));
            this.e.setBlankView(this.m);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.a.checkUpIsLogin() && this.a.L1()) {
            k45 d2 = this.a.d2();
            if (d2 != null && (d2.B() || d2.D())) {
                this.a.d2().z(false, null);
                return;
            }
            if (this.T != null) {
                I();
            }
            B();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            D();
        }
    }

    public void v(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.a.hideProgressBar();
            if (z && z2) {
                FoldCommentActivity foldCommentActivity = this.a;
                foldCommentActivity.showToast(foldCommentActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f121c));
            } else if (z2) {
                if (pi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c3d);
                }
                this.a.showToast(str);
            }
        }
    }

    public BdTypeListView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.o : (BdTypeListView) invokeV.objValue;
    }

    public PbFakeFloorModel x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.X : (PbFakeFloorModel) invokeV.objValue;
    }

    public gw7 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.U : (gw7) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (!pi.isEmpty(this.O)) {
                return this.O;
            }
            if (this.a != null) {
                this.O = TbadkCoreApplication.getInst().getResources().getString(kx7.b());
            }
            return this.O;
        }
        return (String) invokeV.objValue;
    }
}
