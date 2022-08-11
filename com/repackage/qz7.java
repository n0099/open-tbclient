package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.EllipsizeRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.av4;
import com.repackage.bl5;
import com.repackage.fk8;
import com.repackage.fs4;
import com.repackage.hu7;
import com.repackage.mz5;
import com.repackage.ur4;
import com.repackage.wr4;
import com.repackage.yk5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class qz7 implements KeyboardEventLayout.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int p0;
    public static int q0;
    public transient /* synthetic */ FieldHolder $fh;
    public uu4 A;
    public tz7 B;
    public View C;
    public MorePopupWindow D;
    public View E;
    public wr4 F;
    public View G;
    public BlankView H;
    public View I;
    public ds4 J;
    public ur4 K;
    public View.OnClickListener L;
    public wr4 M;
    public boolean N;
    public ProgressBar O;
    public NewSubPbActivity.s0 P;
    public NewSubPbActivity.s0 Q;
    public o45 R;
    public int S;
    public ArrayList<PostData> T;
    public vt7 U;
    public TextView V;
    public RelativeLayout W;
    public ImageView X;
    public ImageView Y;
    public LinearLayout Z;
    public SubPbView a;
    public ImageView a0;
    public LinearLayout b;
    public View b0;
    public View c;
    public int c0;
    public BdTypeListView d;
    public int d0;
    public y18 e;
    public SubPbModel e0;
    public NewSubPbActivity f;
    public int f0;
    public NoNetworkView g;
    public boolean g0;
    public NoDataView h;
    public yk5 h0;
    public View.OnClickListener i;
    public bl5 i0;
    public RelativeLayout j;
    public sz7 j0;
    public NavigationBar k;
    public av4.g k0;
    public ImageView l;
    public MaskView l0;
    public View m;
    public BdUniqueId m0;
    public TextView n;
    public final CustomMessageListener n0;
    public LinearLayout o;
    public hu7 o0;
    public HeadImageView p;
    public TextView q;
    public View r;
    public ImageView s;
    public TextView t;
    public TextView u;
    public EllipsizeRichTextView v;
    public TbImageView w;
    public PlayVoiceBntNew x;
    public TextView y;
    public ThreadSkinView z;

    /* loaded from: classes7.dex */
    public class a implements fk8.g {
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

        @Override // com.repackage.fk8.g
        public void h0(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                this.a.M();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.H == null) {
                return;
            }
            this.a.a.g();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ qz7 b;

        public c(qz7 qz7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz7Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int headerViewsCount = this.a + this.b.d.getHeaderViewsCount();
                if (headerViewsCount >= 1) {
                    headerViewsCount--;
                }
                this.b.d.setSelection(headerViewsCount);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(qz7 qz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, Integer.valueOf(i)};
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
            this.a = qz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2010045) {
                Object data = customResponsedMessage.getData();
                if (TbadkCoreApplication.getInst().getCurrentActivity() == this.a.f && (data instanceof Boolean)) {
                    this.a.a.setEnableDragExit(!((Boolean) data).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;

        public e(qz7 qz7Var) {
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
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.e0 == null || (!this.a.e0.M0() && !this.a.e0.J0())) {
                    if (this.a.H != null) {
                        this.a.a.g();
                        return;
                    } else {
                        this.a.f.finish();
                        return;
                    }
                }
                this.a.f.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements hu7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;

        public f(qz7 qz7Var) {
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

        @Override // com.repackage.hu7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.hu7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.hu7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                this.a.q(false);
                this.a.q(true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements fs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ qz7 b;

        public g(qz7 qz7Var, boolean z) {
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

        @Override // com.repackage.fs4.e
        public void i0(fs4 fs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, fs4Var, i, view2) == null) {
                this.b.J.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.Z(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fea), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue(), false);
                        return;
                    case 11:
                        if (this.b.P != null) {
                            this.b.P.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f092008), sparseArray.get(R.id.obfuscated_res_0x7f091ff5), sparseArray.get(R.id.obfuscated_res_0x7f091ff8), sparseArray.get(R.id.obfuscated_res_0x7f091ff6), sparseArray.get(R.id.obfuscated_res_0x7f091ff7)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.f.q3(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f092040), sparseArray);
                        return;
                    case 13:
                        this.b.E0(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ qz7 b;

        public h(qz7 qz7Var, SparseArray sparseArray) {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                if (this.b.Q != null) {
                    this.b.Q.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f091fea), this.a.get(R.id.obfuscated_res_0x7f092008), this.a.get(R.id.obfuscated_res_0x7f091feb), this.a.get(R.id.obfuscated_res_0x7f091fec)});
                }
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(qz7 qz7Var) {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements yk5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ qz7 b;

        public j(qz7 qz7Var, SparseArray sparseArray) {
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

        @Override // com.repackage.yk5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.b.Q != null) {
                    this.b.Q.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f091fea), this.a.get(R.id.obfuscated_res_0x7f092008), this.a.get(R.id.obfuscated_res_0x7f091feb), this.a.get(R.id.obfuscated_res_0x7f091fec), JsonArrayToString});
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements bl5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ qz7 b;

        public k(qz7 qz7Var, SparseArray sparseArray) {
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

        @Override // com.repackage.bl5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.b.Q != null) {
                    this.b.Q.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f091fea), this.a.get(R.id.obfuscated_res_0x7f092008), this.a.get(R.id.obfuscated_res_0x7f091feb), this.a.get(R.id.obfuscated_res_0x7f091fec), JsonArrayToString});
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ qz7 b;

        public l(qz7 qz7Var, boolean z) {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.d.setEnabled(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755362749, "Lcom/repackage/qz7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755362749, "Lcom/repackage/qz7;");
                return;
            }
        }
        p0 = TbadkCoreApplication.getInst().getListItemRule().c();
        q0 = 2;
    }

    public qz7(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.B = null;
        this.D = null;
        this.F = null;
        this.G = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.N = true;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = 0;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.c0 = 2;
        this.d0 = 0;
        this.f0 = 0;
        this.g0 = true;
        UbsABTestHelper.showTrisectionAndFeedback();
        this.n0 = new d(this, 2010045);
        this.o0 = new hu7(new f(this));
        this.f = newSubPbActivity;
        this.L = onClickListener;
        this.a = (SubPbView) LayoutInflater.from(newSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0636, (ViewGroup) null);
        this.c = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0635, (ViewGroup) null);
        this.b = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091627);
        this.W = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091f53);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091f54);
        this.V = textView;
        textView.setOnClickListener(this.L);
        this.X = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091f56);
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091f55);
        this.Y = imageView;
        imageView.setOnClickListener(this.L);
        this.X.setOnClickListener(this.L);
        this.g = (NoNetworkView) this.a.findViewById(R.id.obfuscated_res_0x7f09255e);
        P();
        N();
        this.j = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091f46);
        this.d = (BdTypeListView) this.a.findViewById(R.id.obfuscated_res_0x7f091667);
        ThreadSkinView threadSkinView = (ThreadSkinView) LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d086b, (ViewGroup) null);
        this.z = threadSkinView;
        this.d.addHeaderView(threadSkinView);
        this.d.addHeaderView(this.c);
        this.I = new TextView(newSubPbActivity.getActivity());
        this.I.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.d.x(this.I, 0);
        this.a.setTopView(this.I);
        this.a.setNavigationView(this.b);
        this.a.setListView(this.d);
        this.a.setContentView(this.j);
        tz7 tz7Var = new tz7(this.f.getPageContext());
        this.B = tz7Var;
        tz7Var.x();
        this.G = this.B.b();
        this.d.setNextPage(this.B);
        this.B.B(this.L);
        this.d.setOnTouchListener(this.o0);
        y18 y18Var = new y18(newSubPbActivity.getPageContext());
        this.e = y18Var;
        y18Var.n();
        this.e.f(this.k0);
        this.e.H(TbadkCoreApplication.getInst().getSkinType());
        this.O = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091a78);
        this.l0 = (MaskView) this.a.findViewById(R.id.obfuscated_res_0x7f0914a0);
        this.b0 = this.a.findViewById(R.id.obfuscated_res_0x7f092544);
        this.Z = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0917ba);
        ImageView imageView2 = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090872);
        this.a0 = imageView2;
        imageView2.setVisibility(0);
        this.a0.setOnClickListener(this.L);
        ImageView imageView3 = this.a0;
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.obfuscated_res_0x7f08099b);
            p();
        }
        X(TbadkCoreApplication.getInst().getSkinType());
        View view2 = this.c;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View a2 = ml4.b().a(this.f.getActivity(), 4);
        this.r = a2;
        if (a2 != null) {
            a2.setVisibility(8);
            this.o.addView(this.r, 3);
        }
        sz7 sz7Var = new sz7(this.f, this.d);
        this.j0 = sz7Var;
        sz7Var.f(this.N);
        this.j0.d(this.L);
        this.j0.b();
    }

    public View A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : (View) invokeV.objValue;
    }

    public void A0(vt7 vt7Var, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int i5;
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{vt7Var, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || vt7Var == null) {
            return;
        }
        if (this.g0 && (view2 = this.c) != null) {
            view2.setVisibility(8);
            this.d.removeHeaderView(this.c);
            this.c0 = 1;
        }
        this.U = vt7Var;
        if (vt7Var.i() != null) {
            this.U.i().f0 = true;
        }
        View view3 = this.c;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.n.setText(R.string.obfuscated_res_0x7f0f1547);
        if (vt7Var.i() != null) {
            int B = vt7Var.i().B();
            this.S = B;
            if (B > 0) {
                this.k.setCenterTextTitle(String.format(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f1213), Integer.valueOf(this.S)));
                NewSubPbActivity newSubPbActivity = this.f;
                if (newSubPbActivity != null) {
                    this.V.setText(newSubPbActivity.l3());
                }
            } else {
                this.k.setCenterTextTitle(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f0a4a));
            }
            String str = this.f.C3() ? "PB" : null;
            if (vt7Var.i().X() != null) {
                this.z.setData(this.f.getPageContext(), vt7Var.i().X(), hl8.a("PB", "c0132", vt7Var.d().getId(), vt7Var.d().getName(), vt7Var.l().getId(), str));
            } else {
                this.z.setData(null, null, null);
            }
        }
        if (vt7Var.o()) {
            this.B.Q();
            this.j0.g(true);
        } else {
            this.B.f();
            this.j0.g(false);
        }
        ArrayList<PostData> k2 = vt7Var.k();
        this.T = k2;
        if (k2 == null || k2.size() <= p0) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            int size = this.T.size() - p0;
            c0(size);
            int firstVisiblePosition = this.d.getFirstVisiblePosition() - size;
            View childAt = this.d.getChildAt(0);
            i3 = size;
            i4 = firstVisiblePosition;
            i5 = childAt == null ? 0 : childAt.getTop();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.T);
        if (ListUtils.isEmpty(this.T)) {
            this.d.setNextPage(null);
            if (this.g0) {
                arrayList.add(0, new yz7());
            }
        } else {
            this.d.setNextPage(this.B);
        }
        zz7 zz7Var = new zz7();
        zz7Var.b(vt7Var.m());
        arrayList.add(0, zz7Var);
        if (this.g0) {
            arrayList.add(0, vt7Var.i());
        }
        NewSubPbActivity newSubPbActivity2 = this.f;
        if (newSubPbActivity2 != null && newSubPbActivity2.m3() != null) {
            this.l0.setVisibility(this.f.m3().N0() ? 0 : 8);
        }
        this.j0.e(this.U.l(), arrayList);
        r(vt7Var, vt7Var.i(), vt7Var.e(), vt7Var.f(), i2, z);
        if (i3 > 0) {
            this.d.setSelectionFromTop(i4, i5);
        } else if (z2 && !pi.isEmpty(this.f.m3().s0())) {
            String s0 = this.f.m3().s0();
            int i6 = 0;
            while (true) {
                if (i6 < arrayList.size()) {
                    if ((arrayList.get(i6) instanceof PostData) && s0.equals(((PostData) arrayList.get(i6)).K())) {
                        this.d.post(new c(this, i6));
                        break;
                    }
                    i6++;
                } else {
                    break;
                }
            }
        }
        if (this.U.j() > 1) {
            this.d.setPullRefresh(this.e);
            this.a.setEnableDragExit(false);
            return;
        }
        this.d.setPullRefresh(null);
        this.a.setEnableDragExit(true);
    }

    public ListView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (ListView) invokeV.objValue;
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j0.a() : invokeV.booleanValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.G : (View) invokeV.objValue;
    }

    public final void C0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, metaData) == null) || metaData == null) {
            return;
        }
        String name_show = metaData.getName_show();
        if (if5.b(name_show) + (!StringUtils.isNull(metaData.getSealPrefix()) ? pi.byteLength(metaData.getSealPrefix()) + 2 : 0) > 14) {
            String k2 = if5.k(name_show, 0, 14);
            if (k2.length() == name_show.length()) {
                name_show = k2;
            } else {
                name_show = k2 + StringHelper.STRING_MORE;
            }
        }
        if (!StringUtils.isNull(metaData.getSealPrefix())) {
            this.q.setText(J(metaData.getSealPrefix(), name_show));
        } else {
            this.q.setText(name_show);
        }
        if (metaData.getAlaUserData() != null && this.r != null) {
            if (metaData.getAlaUserData().anchor_live == 0) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                ll4 ll4Var = new ll4();
                ll4Var.a = metaData.getAlaUserData();
                ll4Var.b = 4;
                this.r.setTag(ll4Var);
            }
        }
        if (metaData.isBigV()) {
            SkinManager.setViewTextColor(this.q, (int) R.color.cp_cont_r);
        } else if (UbsABTestHelper.isPBPlanA()) {
            ms4.d(this.q).v(R.color.CAM_X0108);
        } else {
            ms4.d(this.q).v(R.color.CAM_X0106);
        }
        this.p.setVisibility(0);
        this.p.setUserId(metaData.getUserId());
        this.p.setUserName(metaData.getUserName());
        this.p.setDefaultResource(R.drawable.obfuscated_res_0x7f08120f);
        UtilHelper.showHeadImageViewBigV(this.p, metaData);
        this.p.K(metaData.getAvater(), 28, false);
        this.o.setTag(R.id.obfuscated_res_0x7f09203d, metaData.getUserId());
        this.o.setTag(R.id.obfuscated_res_0x7f092045, metaData.getUserName());
        this.o.setTag(R.id.obfuscated_res_0x7f092047, metaData.getVirtualUserUrl());
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            NavigationBar navigationBar = this.k;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public void D0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeListView = this.d) == null) {
            return;
        }
        this.d0 = bdTypeListView.getLastVisiblePosition();
    }

    public ImageView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.Y : (ImageView) invokeV.objValue;
    }

    public void E0(boolean z) {
        NewSubPbActivity newSubPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            sz7 sz7Var = this.j0;
            if (sz7Var != null) {
                sz7Var.i(z);
                this.j0.c();
            }
            if (z && (newSubPbActivity = this.f) != null) {
                jz7.d(newSubPbActivity.getPageContext(), this.e0, this);
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            vt7 vt7Var = this.U;
            TiebaStatic.log(statisticItem.param("fid", (vt7Var == null || vt7Var.d() == null) ? "0" : this.U.d().getId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "2"));
        }
    }

    public ImageView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.X : (ImageView) invokeV.objValue;
    }

    public TextView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.V : (TextView) invokeV.objValue;
    }

    public TextView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.v : (TextView) invokeV.objValue;
    }

    public View I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder J(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new mz5.a(str, R.drawable.pic_smalldot_title));
            return mz5.h(this.f.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void K() {
        uu4 uu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (uu4Var = this.A) == null) {
            return;
        }
        uu4Var.h(false);
    }

    public void L() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (noDataView = this.h) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.d.setVisibility(0);
        this.W.setVisibility(0);
        this.a.setOnTouchListener(null);
    }

    public void M() {
        o45 o45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.V == null || (o45Var = this.R) == null) {
            return;
        }
        if (o45Var.w()) {
            this.V.setText(R.string.obfuscated_res_0x7f0f0519);
        } else {
            this.V.setText(this.f.l3());
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091f57);
            this.o = linearLayout;
            linearLayout.setOnClickListener(this.L);
            HeadImageView headImageView = (HeadImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09197d);
            this.p = headImageView;
            headImageView.setRadius(qi.f(this.f.getActivity(), R.dimen.tbds45));
            this.p.setClickable(false);
            this.q = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092450);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09245f);
            this.s = imageView;
            imageView.setVisibility(8);
            this.t = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0909f3);
            this.u = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09218f);
            EllipsizeRichTextView ellipsizeRichTextView = (EllipsizeRichTextView) this.c.findViewById(R.id.obfuscated_res_0x7f0906db);
            this.v = ellipsizeRichTextView;
            ellipsizeRichTextView.setOnClickListener(this.L);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0105);
            this.v.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            this.v.setLineSpacing(0.0f, 1.25f);
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091f47);
            this.w = tbImageView;
            tbImageView.setOnClickListener(this.L);
            this.y = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090144);
            this.x = (PlayVoiceBntNew) this.c.findViewById(R.id.obfuscated_res_0x7f0925a6);
            this.c.setOnTouchListener(this.o0);
            this.c.setOnClickListener(this.L);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.n0.setTag(this.m0);
            MessageManager.getInstance().registerListener(this.n0);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            int f2 = qi.f(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070306);
            int f3 = qi.f(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d4);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f09255c);
            this.k = navigationBar;
            this.m = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
            ImageView backImageView = this.k.getBackImageView();
            this.l = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.height = f2;
                layoutParams.width = f2;
                layoutParams.leftMargin = f3;
                backImageView.setLayoutParams(layoutParams);
            }
            View view2 = this.m;
            if (view2 != null && (view2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.width = f2;
                layoutParams2.height = f2;
                this.m.setLayoutParams(layoutParams2);
            }
            this.k.hideBottomLine();
            TextView textView = new TextView(this.f);
            this.n = textView;
            ms4 d2 = ms4.d(textView);
            d2.v(R.color.CAM_X0304);
            d2.z(R.dimen.T_X07);
            d2.A(R.string.F_X01);
            this.k.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.n, (View.OnClickListener) null);
            ViewCommonUtil.setViewMarginByDimen(this.n, -1, -1, R.dimen.M_W_X007, -1);
            this.n.setOnClickListener(this.L);
        }
    }

    public final void Q(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fb8), this.i));
            if (this.h == null) {
                Activity pageActivity = this.f.getPageContext().getPageActivity();
                this.h = NoDataViewFactory.a(pageActivity, this.j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, qi.f(pageActivity, R.dimen.obfuscated_res_0x7f070288)), eVar, a2);
            }
            this.d.setVisibility(8);
            this.O.setVisibility(8);
            this.R.y();
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            this.h.setClickable(true);
            this.h.setTextOption(eVar);
            this.h.f(this.f.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.h.setVisibility(0);
        }
    }

    public void R(o45 o45Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, o45Var) == null) || o45Var == null || o45Var.a() == null) {
            return;
        }
        this.R = o45Var;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.j.addView(o45Var.a(), layoutParams);
        this.R.R(new a(this));
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.a.e() : invokeV.booleanValue;
    }

    public void T() {
        sz7 sz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (sz7Var = this.j0) == null) {
            return;
        }
        sz7Var.c();
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            SubPbView subPbView = this.a;
            if (subPbView != null) {
                subPbView.f();
            }
            o45 o45Var = this.R;
            if (o45Var != null) {
                o45Var.D();
            }
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    public void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.f.getLayoutMode().l(i2 == 1);
            this.f.getLayoutMode().k(this.a);
            this.f.getLayoutMode().k(this.c);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            this.k.onChangeSkinType(this.f.getPageContext(), i2);
            SubPbModel subPbModel = this.e0;
            if (subPbModel != null && (subPbModel.M0() || this.e0.J0())) {
                WebPManager.setPureDrawable(this.l, R.drawable.obfuscated_res_0x7f080a01, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.l, R.drawable.obfuscated_res_0x7f0809f2, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            TextView textView = this.n;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0304);
            }
            this.g.d(this.f.getPageContext(), i2);
            this.f.getLayoutMode().k(this.G);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0105);
            this.v.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            o45 o45Var = this.R;
            if (o45Var != null && o45Var.a() != null) {
                this.R.a().w(i2);
            }
            this.B.d(i2);
            this.x.e();
            SkinManager.setViewTextColor(this.V, (int) R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0302);
            if (UbsABTestHelper.isPBPlanA()) {
                ms4.d(this.q).A(R.string.F_X02);
                ms4.d(this.q).v(R.color.CAM_X0108);
            } else {
                ms4.d(this.q).A(R.string.F_X01);
                SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0106);
            }
            this.V.setAlpha(0.95f);
            if (this.C != null) {
                fb5.a(this.f.getPageContext(), this.C);
            }
            sz7 sz7Var = this.j0;
            if (sz7Var != null) {
                sz7Var.c();
            }
            this.f.getLayoutMode().k(this.E);
            SkinManager.setBackgroundColor(this.b0, R.color.CAM_X0203);
            WebPManager.setPureDrawable(this.a0, R.drawable.obfuscated_res_0x7f08099b, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            this.Z.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(qi.f(this.f, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            ms4.d(this.W).f(R.color.CAM_X0208);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048605, this) != null) || this.f.F3()) {
        }
    }

    public void Z(int i2, String str, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fea, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z));
            int i4 = (i3 != 1002 || z) ? R.string.obfuscated_res_0x7f0f04a0 : R.string.obfuscated_res_0x7f0f0ff3;
            if (i2 == 0) {
                i4 = (i3 != 1002 || z) ? R.string.obfuscated_res_0x7f0f04a9 : R.string.obfuscated_res_0x7f0f0ff7;
            }
            ur4 ur4Var = new ur4(this.f.getPageContext().getPageActivity());
            this.K = ur4Var;
            ur4Var.setMessageId(i4);
            this.K.setYesButtonTag(sparseArray);
            this.K.setPositiveButton(R.string.obfuscated_res_0x7f0f04ee, new h(this, sparseArray));
            this.K.setNegativeButton(R.string.obfuscated_res_0x7f0f04e9, new i(this));
            this.K.setCancelable(true);
            this.K.create(this.f.getPageContext());
            if (z2) {
                this.K.show();
            } else if (z) {
                this.K.show();
            } else if (1 == this.e0.o0()) {
                al5 al5Var = new al5(this.e0.o0(), this.e0.n0(), this.e0.r0());
                al5Var.i(this.U.d().getId(), this.U.d().getName());
                al5Var.h(this.e0.p0());
                al5Var.j(this.e0.F0());
                UserData userData = new UserData();
                userData.setIsManager(this.e0.t0());
                u0(sparseArray, al5Var, userData);
            } else {
                y0(sparseArray);
            }
        }
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
        }
    }

    public void a0(SparseArray<Object> sparseArray, boolean z) {
        bs4 bs4Var;
        bs4 bs4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, sparseArray, z) == null) {
            fs4 fs4Var = new fs4(this.f.getBaseContext());
            fs4Var.q(this.f.getString(R.string.obfuscated_res_0x7f0f02e3));
            fs4Var.n(new g(this, z));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091fe4) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fe4)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091fea)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091fec) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue() : -1) == 0) {
                    bs4Var2 = new bs4(10, this.f.getString(R.string.obfuscated_res_0x7f0f04b6), fs4Var);
                } else {
                    bs4Var2 = new bs4(10, this.f.getString(R.string.obfuscated_res_0x7f0f04ab), fs4Var);
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
                bs4 bs4Var3 = new bs4(13, this.f.getString(R.string.obfuscated_res_0x7f0f0b23), fs4Var);
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
                bs4 bs4Var4 = new bs4(11, this.f.getString(R.string.obfuscated_res_0x7f0f0654), fs4Var);
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
                    bs4Var = new bs4(12, this.f.getString(R.string.obfuscated_res_0x7f0f1497), fs4Var);
                } else {
                    bs4Var = new bs4(12, this.f.getString(R.string.obfuscated_res_0x7f0f0b2f), fs4Var);
                }
                bs4Var.d.setTag(sparseArray5);
                arrayList.add(bs4Var);
            }
            fz7.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                fs4Var.k(arrayList, false);
            } else {
                fs4Var.k(arrayList, true);
            }
            ds4 ds4Var = new ds4(this.f.getPageContext(), fs4Var);
            this.J = ds4Var;
            ds4Var.k();
        }
    }

    public void b0(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        a0(sparseArray, false);
    }

    public final void c0(int i2) {
        ArrayList<PostData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048610, this, i2) == null) || (arrayList = this.T) == null) {
            return;
        }
        if (arrayList.size() <= i2) {
            this.T.clear();
        }
        int i3 = 0;
        Iterator<PostData> it = this.T.iterator();
        while (it.hasNext()) {
            it.next();
            i3++;
            it.remove();
            if (i3 >= i2) {
                return;
            }
        }
    }

    public void d0(NewSubPbActivity.s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, s0Var) == null) {
            this.Q = s0Var;
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.d.setVisibility(0);
            this.O.setVisibility(8);
            this.B.f();
        }
    }

    public void f0(NewSubPbActivity.s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, s0Var) == null) {
            this.P = s0Var;
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.g0 = z;
        }
    }

    public void h0(av4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, gVar) == null) {
            this.k0 = gVar;
            y18 y18Var = this.e;
            if (y18Var != null) {
                y18Var.f(gVar);
            }
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.d.setVisibility(0);
            this.O.setVisibility(8);
            this.B.R();
        }
    }

    public void j0(SubPbModel subPbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, subPbModel) == null) {
            this.e0 = subPbModel;
        }
    }

    public void k(boolean z) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048618, this, z) == null) || (subPbModel = this.e0) == null || !subPbModel.L0() || z) {
            return;
        }
        this.k.setIsClose(true);
        this.k.setIsCorner(true);
        this.k.isShowBottomLine(true);
        this.k.setBottomLineHeight(3);
        this.k.setStatusBarVisibility(8);
        this.H = new BlankView(this.f.getPageContext().getPageActivity());
        if (this.e0.M0()) {
            this.f0 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds562) + UtilHelper.getStatusBarHeight();
        } else {
            this.f0 = qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070252);
        }
        this.b.addView(this.H, 0, new LinearLayout.LayoutParams(-1, this.f0));
        this.H.setVisibility(0);
        this.H.setOnClickListener(new b(this));
        this.a.setBlankView(this.H);
    }

    public void k0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, yVar) == null) {
            this.j0.j(yVar);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            o0(this.f);
            this.d.setNextPage(this.B);
        }
    }

    public void l0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onLongClickListener) == null) {
            this.j0.h(onLongClickListener);
        }
    }

    public void m() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || this.e0 == null) {
            return;
        }
        if ((!B0() && (view2 = this.G) != null && view2.isShown()) || ListUtils.isEmpty(this.T)) {
            this.e0.b1(false);
        } else {
            this.e0.b1(true);
        }
    }

    public void m0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x024e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(PostData postData, int i2, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048624, this, postData, i2, sparseArray) == null) || postData == null) {
            return;
        }
        SparseArray<Object> sparseArray2 = sparseArray == null ? new SparseArray<>() : sparseArray;
        if (i2 != 0) {
            if (i2 != 3) {
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            String userId2 = postData.s().getUserId();
            if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = false;
            }
            if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                z = false;
            }
        } else {
            z = false;
            z2 = false;
        }
        vt7 vt7Var = this.U;
        if (vt7Var != null && vt7Var.l() != null && this.U.l().getAuthor() != null && postData.s() != null) {
            String userId3 = this.U.l().getAuthor().getUserId();
            String userId4 = postData.s().getUserId();
            if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = true;
                    z4 = false;
                    userId = postData.s().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = true;
                    }
                    int i3 = postData.B() == 1 ? 0 : 1;
                    if (z) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(i2));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ff8, postData.K());
                        if (postData.s() != null) {
                            sparseArray2.put(R.id.obfuscated_res_0x7f091ff5, postData.s().getUserName());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091ff6, postData.s().getName_show());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091ff7, postData.s().getPortrait());
                        }
                        z5 = true;
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ff5, "");
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ff6, "");
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ff7, "");
                        z5 = false;
                    }
                    if (z2) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(i2));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091feb, Boolean.TRUE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091fec, Integer.valueOf(i3));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091fea, postData.K());
                        z5 = true;
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091feb, Boolean.FALSE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091fec, 0);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091fea, "");
                    }
                    sparseArray2.put(R.id.obfuscated_res_0x7f092030, Boolean.valueOf(z5));
                    sparseArray2.put(R.id.obfuscated_res_0x7f091ff8, postData.K());
                    if (z) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(i2));
                        if (postData.s() != null) {
                            sparseArray2.put(R.id.obfuscated_res_0x7f091ff5, postData.s().getUserName());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091ff6, postData.s().getName_show());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091ff7, postData.s().getPortrait());
                        }
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091fff, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.s() != null) {
                            sparseArray2.put(R.id.obfuscated_res_0x7f092040, postData.s().getUserId());
                            sparseArray2.put(R.id.obfuscated_res_0x7f092041, postData.s().getUserName());
                            sparseArray2.put(R.id.obfuscated_res_0x7f09203f, postData.s().getName_show());
                        }
                        if (this.U.l() != null) {
                            sparseArray2.put(R.id.obfuscated_res_0x7f092043, this.U.l().getId());
                        }
                        sparseArray2.put(R.id.obfuscated_res_0x7f092042, postData.K());
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                    }
                    if (z2) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(i2));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z4));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091fec, Integer.valueOf(i3));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091fea, postData.K());
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ffc, Boolean.valueOf(postData.n0()));
                        return;
                    }
                    sparseArray2.put(R.id.obfuscated_res_0x7f09202e, Boolean.FALSE);
                    return;
                }
                z2 = true;
                z3 = false;
                z4 = true;
                userId = postData.s().getUserId();
                if (userId != null) {
                    z2 = true;
                    z4 = true;
                }
                if (postData.B() == 1) {
                }
                if (z) {
                }
                if (z2) {
                }
                sparseArray2.put(R.id.obfuscated_res_0x7f092030, Boolean.valueOf(z5));
                sparseArray2.put(R.id.obfuscated_res_0x7f091ff8, postData.K());
                if (z) {
                }
                if (z3) {
                }
                if (z2) {
                }
            }
        }
        z3 = false;
        z4 = false;
        userId = postData.s().getUserId();
        if (userId != null) {
        }
        if (postData.B() == 1) {
        }
        if (z) {
        }
        if (z2) {
        }
        sparseArray2.put(R.id.obfuscated_res_0x7f092030, Boolean.valueOf(z5));
        sparseArray2.put(R.id.obfuscated_res_0x7f091ff8, postData.K());
        if (z) {
        }
        if (z3) {
        }
        if (z2) {
        }
    }

    public void n0(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, onScrollListener) == null) {
            this.d.setOnScrollListener(onScrollListener);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            MorePopupWindow morePopupWindow = this.D;
            if (morePopupWindow != null) {
                tg.d(morePopupWindow, this.f.getPageContext().getPageActivity());
            }
            wr4 wr4Var = this.F;
            if (wr4Var != null) {
                wr4Var.e();
            }
            ur4 ur4Var = this.K;
            if (ur4Var != null) {
                ur4Var.dismiss();
            }
            ds4 ds4Var = this.J;
            if (ds4Var != null) {
                tg.b(ds4Var, this.f.getPageContext());
            }
            ProgressBar progressBar = this.O;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
    }

    public void o0(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, pVar) == null) {
            this.d.setOnSrollToBottomListener(pVar);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", q0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void p0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bdUniqueId) == null) {
            this.m0 = bdUniqueId;
            O();
        }
    }

    public final void q(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048630, this, z) == null) || (bdTypeListView = this.d) == null) {
            return;
        }
        if (!z) {
            bdTypeListView.setEnabled(z);
        } else {
            bdTypeListView.postDelayed(new l(this, z), 10L);
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.O.setVisibility(0);
        }
    }

    public void r(vt7 vt7Var, PostData postData, boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{vt7Var, postData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) || postData == null || this.g0) {
            return;
        }
        if (!StringUtils.isNull(postData.A())) {
            this.w.setVisibility(0);
            this.w.K(postData.A(), 10, true);
        } else {
            this.w.setVisibility(8);
        }
        vk8 w = postData.w();
        if (w != null && w.a) {
            this.y.setVisibility(0);
        } else {
            this.y.setVisibility(8);
        }
        SparseArray<Object> sparseArray = (SparseArray) this.c.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.c.setTag(sparseArray);
        }
        sparseArray.clear();
        sparseArray.put(R.id.obfuscated_res_0x7f091fe8, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092001, Boolean.FALSE);
        n(postData, i2, sparseArray);
        this.q.setText((CharSequence) null);
        this.t.setVisibility(8);
        if (!this.g0) {
            C0(postData.s());
            if (z) {
                this.t.setVisibility(0);
                SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0302);
            }
        }
        this.u.setText(StringHelper.getFormatTime(postData.e0()));
        postData.s().getUserTbVipInfoData();
        boolean r0 = r0(this.v, postData.V());
        if (StringUtils.isNull(postData.A()) && !r0 && postData.k0() != null) {
            this.x.setVisibility(0);
            this.x.setTag(postData.k0());
            return;
        }
        this.x.setVisibility(8);
    }

    public final boolean r0(TextView textView, TbRichText tbRichText) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048633, this, textView, tbRichText)) == null) {
            if (textView != null && tbRichText != null && tbRichText.B() != null) {
                TbRichTextData tbRichTextData = new TbRichTextData(1);
                Iterator<TbRichTextData> it = tbRichText.B().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        int type = next.getType();
                        if (type != 1) {
                            if (type != 2) {
                                if (type == 17) {
                                    String str = next.C().mGifInfo.mSharpText;
                                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                                        String substring = str.substring(2, str.length() - 1);
                                        tbRichTextData.A(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                                    }
                                } else if (type != 18 && type != 1282) {
                                }
                            }
                            tbRichTextData.U(true);
                            textView.setMovementMethod(mw8.a());
                        } else {
                            tbRichTextData.A(next.J());
                        }
                    }
                }
                if (!tbRichTextData.Q()) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                try {
                    if (tbRichTextData.J() == null || tbRichTextData.J().length() <= 0) {
                        return false;
                    }
                    textView.setText(tbRichTextData.J());
                    return true;
                } catch (Exception unused) {
                    textView.setText("");
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void s(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            ProgressBar progressBar = this.O;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (z && z2) {
                NewSubPbActivity newSubPbActivity = this.f;
                newSubPbActivity.showToast(newSubPbActivity.getResources().getString(R.string.obfuscated_res_0x7f0f04b9));
            } else if (str == null || !z2) {
            } else {
                this.f.showToast(str);
            }
        }
    }

    public void s0(PostData postData) {
        int i2;
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, postData) == null) || postData == null) {
            return;
        }
        postData.L0(true);
        PostData postData2 = new PostData();
        postData2.S0(52);
        if (!B0() && (view2 = this.G) != null && view2.isShown()) {
            i2 = (this.d0 - this.c0) - 1;
        } else {
            i2 = this.d0 - this.c0;
        }
        int count = ListUtils.getCount(this.T);
        if (i2 > count) {
            i2 = count;
        }
        ArrayList arrayList = new ArrayList(ListUtils.subList(this.T, 0, i2));
        ListUtils.add(arrayList, postData2);
        ListUtils.add(arrayList, postData);
        this.d.smoothScrollToPosition(this.d0 + 2);
        this.d.setNextPage(null);
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            BlankView blankView = this.H;
            if (blankView == null) {
                return 0;
            }
            return blankView.getHeight();
        }
        return invokeV.intValue;
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            if (this.A == null) {
                this.A = new uu4(this.f.getPageContext());
            }
            this.A.h(true);
        }
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public final void u0(SparseArray<Object> sparseArray, al5 al5Var, UserData userData) {
        NewSubPbActivity newSubPbActivity;
        AntiData k0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048639, this, sparseArray, al5Var, userData) == null) || (newSubPbActivity = this.f) == null || sparseArray == null || this.c == null) {
            return;
        }
        if (this.i0 == null) {
            this.i0 = new bl5(newSubPbActivity.getPageContext(), this.c, al5Var, userData);
        }
        SparseArray<String> sparseArray2 = new SparseArray<>();
        SubPbModel subPbModel = this.e0;
        if (subPbModel != null && (k0 = subPbModel.k0()) != null && k0.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = k0.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        cq4 cq4Var = new cq4();
        cq4Var.j(sparseArray2);
        this.i0.E(new String[]{this.f.getString(R.string.obfuscated_res_0x7f0f04bf), this.f.getString(R.string.obfuscated_res_0x7f0f04c0), this.f.getString(R.string.obfuscated_res_0x7f0f04c1), this.f.getString(R.string.obfuscated_res_0x7f0f04c2), this.f.getString(R.string.obfuscated_res_0x7f0f04c3)});
        this.i0.D(cq4Var);
        this.i0.G("4");
        this.i0.F(new k(this, sparseArray));
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            o45 o45Var = this.R;
            if (o45Var == null || o45Var.a() == null) {
                return 0;
            }
            return this.R.a().getHeight();
        }
        return invokeV.intValue;
    }

    public void v0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            Q(NoDataViewFactory.e.d(null, this.f.getResources().getString(R.string.obfuscated_res_0x7f0f0fb9)));
            this.W.setVisibility(8);
        }
    }

    public ImageView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.a0 : (ImageView) invokeV.objValue;
    }

    public void w0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048643, this, str, z) == null) {
            if (z) {
                Q(NoDataViewFactory.e.d("", str));
            } else {
                Q(NoDataViewFactory.e.d(str, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fb9)));
            }
            this.W.setVisibility(8);
        }
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.w : (View) invokeV.objValue;
    }

    public void x0(wr4.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048645, this, cVar, z) == null) {
            wr4 wr4Var = this.M;
            if (wr4Var != null) {
                wr4Var.e();
                this.M = null;
            }
            wr4 wr4Var2 = new wr4(this.f.getPageContext().getPageActivity());
            this.M = wr4Var2;
            if (z) {
                wr4Var2.j(new String[]{this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f108d)}, cVar);
            } else {
                wr4Var2.j(new String[]{this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f108d), this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f108e)}, cVar);
            }
            this.M.c(this.f.getPageContext());
            this.M.m();
        }
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public final void y0(SparseArray<Object> sparseArray) {
        NewSubPbActivity newSubPbActivity;
        AntiData k0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048647, this, sparseArray) == null) || (newSubPbActivity = this.f) == null || sparseArray == null || this.c == null) {
            return;
        }
        if (this.h0 == null) {
            this.h0 = new yk5(newSubPbActivity.getPageContext(), this.c);
        }
        SparseArray<String> sparseArray2 = new SparseArray<>();
        SubPbModel subPbModel = this.e0;
        if (subPbModel != null && (k0 = subPbModel.k0()) != null && k0.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = k0.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        cq4 cq4Var = new cq4();
        cq4Var.j(sparseArray2);
        this.h0.y(new String[]{this.f.getString(R.string.obfuscated_res_0x7f0f04bf), this.f.getString(R.string.obfuscated_res_0x7f0f04c0), this.f.getString(R.string.obfuscated_res_0x7f0f04c1), this.f.getString(R.string.obfuscated_res_0x7f0f04c2), this.f.getString(R.string.obfuscated_res_0x7f0f04c3)});
        this.h0.x(cq4Var);
        this.h0.A("4");
        this.h0.z(new j(this, sparseArray));
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            this.d.setNextPage(this.B);
            this.B.Q();
        }
    }
}
