package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.ViewHelper;
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
import com.repackage.dr4;
import com.repackage.fr4;
import com.repackage.gu4;
import com.repackage.lj5;
import com.repackage.ls7;
import com.repackage.oj5;
import com.repackage.ox7;
import com.repackage.rh8;
import com.repackage.ux5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class nx7 implements KeyboardEventLayout.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int t0;
    public static int u0;
    public transient /* synthetic */ FieldHolder $fh;
    public bu4 A;
    public qx7 B;
    public View C;
    public MorePopupWindow D;
    public View E;
    public fr4 F;
    public View G;
    public BlankView H;
    public View I;
    public Dialog J;
    public dr4 K;
    public View.OnClickListener L;
    public fr4 M;
    public boolean N;
    public ProgressBar O;
    public NewSubPbActivity.r0 P;
    public NewSubPbActivity.r0 Q;
    public s35 R;
    public int S;
    public ArrayList<PostData> T;
    public zr7 U;
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
    public wu7 c0;
    public BdTypeListView d;
    public int d0;
    public vz7 e;
    public int e0;
    public NewSubPbActivity f;
    public SubPbModel f0;
    public NoNetworkView g;
    public int g0;
    public NoDataView h;
    public boolean h0;
    public View.OnClickListener i;
    public lj5 i0;
    public RelativeLayout j;
    public oj5 j0;
    public NavigationBar k;
    public px7 k0;
    public ImageView l;
    public boolean l0;
    public View m;
    public gu4.g m0;
    public TextView n;
    public MaskView n0;
    public LinearLayout o;
    public BdUniqueId o0;
    public HeadImageView p;
    public final CustomMessageListener p0;
    public TextView q;
    public ls7 q0;
    public View r;
    public AdapterView.OnItemLongClickListener r0;
    public ImageView s;
    public AdapterView.OnItemClickListener s0;
    public TextView t;
    public TextView u;
    public EllipsizeRichTextView v;
    public TbImageView w;
    public PlayVoiceBntNew x;
    public TextView y;
    public ThreadSkinView z;

    /* loaded from: classes6.dex */
    public class a implements oj5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ nx7 b;

        public a(nx7 nx7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nx7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.oj5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.b.Q != null) {
                    this.b.Q.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f091ef3), this.a.get(R.id.obfuscated_res_0x7f091f10), this.a.get(R.id.obfuscated_res_0x7f091ef4), this.a.get(R.id.obfuscated_res_0x7f091ef5), JsonArrayToString});
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ nx7 b;

        public b(nx7 nx7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nx7Var;
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

    /* loaded from: classes6.dex */
    public class c implements rh8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx7 a;

        public c(nx7 nx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nx7Var;
        }

        @Override // com.repackage.rh8.f
        public void i0(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                this.a.V();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx7 a;

        public d(nx7 nx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nx7Var;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
            InterceptResult invokeCommon;
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                PostData postData = (PostData) ListUtils.getItem(this.a.T, i);
                if (view2 != null && view2.getTag() != null) {
                    if (this.a.c0 == null) {
                        this.a.c0 = new wu7(this.a.f.getPageContext(), this.a.L);
                    }
                    this.a.c0.m();
                    try {
                        sparseArray = (SparseArray) view2.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (sparseArray == null) {
                        return true;
                    }
                    PostData postData2 = sparseArray.get(R.id.obfuscated_res_0x7f091ef1) instanceof PostData ? (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091ef1) : null;
                    boolean z = this.a.c0(sparseArray.get(R.id.obfuscated_res_0x7f091ef4) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef4)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                    this.a.c0.q(sparseArray, this.a.f0.F0(), z, this.a.l0 && postData2 != null && postData2.f0, this.a.f0.n0());
                    if (z) {
                        this.a.c0.D().setVisibility(0);
                        this.a.c0.D().setTag(postData.J());
                    } else {
                        this.a.c0.D().setVisibility(8);
                    }
                    this.a.c0.A().setVisibility(8);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx7 a;

        public e(nx7 nx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nx7Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.f != null && ViewHelper.checkUpIsLogin(this.a.f.getPageContext().getPageActivity())) {
                if ((this.a.f.U != null && this.a.f0 != null && this.a.f0.l0() != null && !this.a.f.U.checkPrivacyBeforeInvokeEditor(this.a.f0.l0().replyPrivateFlag)) || this.a.f0 == null || this.a.R == null) {
                    return;
                }
                this.a.O0();
                if (view2 != null && (view2.getTag() instanceof ox7.a)) {
                    this.a.s();
                    this.a.f0.g1();
                    return;
                }
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091f21);
                    String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091f20);
                    String str3 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091f1f);
                    if (str != null) {
                        this.a.R.W(str2);
                        this.a.R.V(str, str3);
                    }
                }
                this.a.t();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx7 a;

        public f(nx7 nx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nx7Var;
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

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ nx7 b;

        public g(nx7 nx7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nx7Var;
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

    /* loaded from: classes6.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(nx7 nx7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var, Integer.valueOf(i)};
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
            this.a = nx7Var;
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

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx7 a;

        public i(nx7 nx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f0 == null || (!this.a.f0.N0() && !this.a.f0.K0())) {
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

    /* loaded from: classes6.dex */
    public class j implements ls7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx7 a;

        public j(nx7 nx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nx7Var;
        }

        @Override // com.repackage.ls7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.ls7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.ls7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                this.a.x(false);
                this.a.x(true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx7 a;

        public k(nx7 nx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.J != null && (this.a.J instanceof Dialog)) {
                    sg.b(this.a.J, this.a.f.getPageContext());
                }
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                this.a.j0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ef5)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091ef3), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091f10)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ef4)).booleanValue(), false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx7 a;

        public l(nx7 nx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nx7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.J != null && (this.a.J instanceof Dialog)) {
                    sg.b(this.a.J, this.a.f.getPageContext());
                }
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null || this.a.P == null) {
                    return;
                }
                this.a.P.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f091f10), sparseArray.get(R.id.obfuscated_res_0x7f091efe), sparseArray.get(R.id.obfuscated_res_0x7f091f01), sparseArray.get(R.id.obfuscated_res_0x7f091eff), sparseArray.get(R.id.obfuscated_res_0x7f091f00)});
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ nx7 b;

        public m(nx7 nx7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nx7Var;
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.J != null && (this.b.J instanceof Dialog)) {
                    sg.b(this.b.J, this.b.f.getPageContext());
                }
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                this.b.f.h3(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f091f44), sparseArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ nx7 b;

        public n(nx7 nx7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nx7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                if (this.b.Q != null) {
                    this.b.Q.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f091ef3), this.a.get(R.id.obfuscated_res_0x7f091f10), this.a.get(R.id.obfuscated_res_0x7f091ef4), this.a.get(R.id.obfuscated_res_0x7f091ef5)});
                }
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(nx7 nx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var};
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

    /* loaded from: classes6.dex */
    public class p implements lj5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ nx7 b;

        public p(nx7 nx7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nx7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nx7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.lj5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.b.Q != null) {
                    this.b.Q.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f091ef3), this.a.get(R.id.obfuscated_res_0x7f091f10), this.a.get(R.id.obfuscated_res_0x7f091ef4), this.a.get(R.id.obfuscated_res_0x7f091ef5), JsonArrayToString});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755454044, "Lcom/repackage/nx7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755454044, "Lcom/repackage/nx7;");
                return;
            }
        }
        t0 = TbadkCoreApplication.getInst().getListItemRule().c();
        u0 = 2;
    }

    public nx7(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
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
        this.d0 = 2;
        this.e0 = 0;
        this.g0 = 0;
        this.h0 = true;
        this.l0 = UbsABTestHelper.showTrisectionAndFeedback();
        this.p0 = new h(this, 2010045);
        this.q0 = new ls7(new j(this));
        this.r0 = new d(this);
        this.s0 = new e(this);
        this.f = newSubPbActivity;
        this.L = onClickListener;
        this.a = (SubPbView) LayoutInflater.from(newSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0616, (ViewGroup) null);
        this.c = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0615, (ViewGroup) null);
        this.b = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09156b);
        this.W = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091e5d);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091e5e);
        this.V = textView;
        textView.setOnClickListener(this.L);
        this.X = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091e60);
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091e5f);
        this.Y = imageView;
        imageView.setOnClickListener(this.L);
        this.X.setOnClickListener(this.L);
        this.g = (NoNetworkView) this.a.findViewById(R.id.obfuscated_res_0x7f09243b);
        Y();
        W();
        this.j = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091e50);
        this.d = (BdTypeListView) this.a.findViewById(R.id.obfuscated_res_0x7f0915a9);
        ThreadSkinView threadSkinView = (ThreadSkinView) LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0841, (ViewGroup) null);
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
        qx7 qx7Var = new qx7(this.f.getPageContext());
        this.B = qx7Var;
        qx7Var.x();
        this.G = this.B.b();
        this.d.setNextPage(this.B);
        this.B.B(this.L);
        this.d.setOnItemClickListener(this.s0);
        this.d.setOnItemLongClickListener(this.r0);
        this.d.setOnTouchListener(this.q0);
        vz7 vz7Var = new vz7(newSubPbActivity.getPageContext());
        this.e = vz7Var;
        vz7Var.n();
        this.e.f(this.m0);
        this.e.H(TbadkCoreApplication.getInst().getSkinType());
        this.O = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f0919a2);
        this.n0 = (MaskView) this.a.findViewById(R.id.obfuscated_res_0x7f0913f9);
        this.b0 = this.a.findViewById(R.id.obfuscated_res_0x7f092421);
        this.Z = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0916ef);
        ImageView imageView2 = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09083b);
        this.a0 = imageView2;
        imageView2.setVisibility(0);
        this.a0.setOnClickListener(this.L);
        ImageView imageView3 = this.a0;
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.obfuscated_res_0x7f08097a);
            w();
        }
        h0(TbadkCoreApplication.getInst().getSkinType());
        View view2 = this.c;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View a2 = vk4.b().a(this.f.getActivity(), 4);
        this.r = a2;
        if (a2 != null) {
            a2.setVisibility(8);
            this.o.addView(this.r, 3);
        }
        px7 px7Var = new px7(this.f, this.d);
        this.k0 = px7Var;
        px7Var.f(this.N);
        this.k0.d(this.L);
        this.k0.b();
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BlankView blankView = this.H;
            if (blankView == null) {
                return 0;
            }
            return blankView.getHeight();
        }
        return invokeV.intValue;
    }

    public void A0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.C = view2;
        }
    }

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.O.setVisibility(0);
        }
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            s35 s35Var = this.R;
            if (s35Var == null || s35Var.a() == null) {
                return 0;
            }
            return this.R.a().getHeight();
        }
        return invokeV.intValue;
    }

    public final boolean C0(TextView textView, TbRichText tbRichText) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, textView, tbRichText)) == null) {
            if (textView != null && tbRichText != null && tbRichText.C() != null) {
                TbRichTextData tbRichTextData = new TbRichTextData(1);
                Iterator<TbRichTextData> it = tbRichText.C().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        int type = next.getType();
                        if (type != 1) {
                            if (type != 2) {
                                if (type == 17) {
                                    String str = next.D().mGifInfo.mSharpText;
                                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                                        String substring = str.substring(2, str.length() - 1);
                                        tbRichTextData.B(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                                    }
                                } else if (type != 18 && type != 1282) {
                                }
                            }
                            tbRichTextData.V(true);
                            textView.setMovementMethod(vt8.a());
                        } else {
                            tbRichTextData.B(next.K());
                        }
                    }
                }
                if (!tbRichTextData.R()) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                try {
                    if (tbRichTextData.K() == null || tbRichTextData.K().length() <= 0) {
                        return false;
                    }
                    textView.setText(tbRichTextData.K());
                    return true;
                } catch (Exception unused) {
                    textView.setText("");
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public ImageView D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a0 : (ImageView) invokeV.objValue;
    }

    public void D0(PostData postData) {
        int i2;
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, postData) == null) || postData == null) {
            return;
        }
        postData.z0(true);
        PostData postData2 = new PostData();
        postData2.D0(52);
        if (!M0() && (view2 = this.G) != null && view2.isShown()) {
            i2 = (this.e0 - this.d0) - 1;
        } else {
            i2 = this.e0 - this.d0;
        }
        int count = ListUtils.getCount(this.T);
        if (i2 > count) {
            i2 = count;
        }
        ArrayList arrayList = new ArrayList(ListUtils.subList(this.T, 0, i2));
        ListUtils.add(arrayList, postData2);
        ListUtils.add(arrayList, postData);
        this.d.smoothScrollToPosition(this.e0 + 2);
        this.d.setNextPage(null);
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.w : (View) invokeV.objValue;
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.A == null) {
                this.A = new bu4(this.f.getPageContext());
            }
            this.A.h(true);
        }
    }

    public View F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public final void F0(SparseArray<Object> sparseArray, nj5 nj5Var, UserData userData) {
        NewSubPbActivity newSubPbActivity;
        AntiData l0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048587, this, sparseArray, nj5Var, userData) == null) || (newSubPbActivity = this.f) == null || sparseArray == null || this.c == null) {
            return;
        }
        if (this.j0 == null) {
            this.j0 = new oj5(newSubPbActivity.getPageContext(), this.c, nj5Var, userData);
        }
        SparseArray<String> sparseArray2 = new SparseArray<>();
        SubPbModel subPbModel = this.f0;
        if (subPbModel != null && (l0 = subPbModel.l0()) != null && l0.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = l0.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        lp4 lp4Var = new lp4();
        lp4Var.j(sparseArray2);
        this.j0.E(new String[]{this.f.getString(R.string.obfuscated_res_0x7f0f04b2), this.f.getString(R.string.obfuscated_res_0x7f0f04b3), this.f.getString(R.string.obfuscated_res_0x7f0f04b4), this.f.getString(R.string.obfuscated_res_0x7f0f04b5), this.f.getString(R.string.obfuscated_res_0x7f0f04b6)});
        this.j0.D(lp4Var);
        this.j0.G("4");
        this.j0.F(new a(this, sparseArray));
    }

    public View G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public void G0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            Z(NoDataViewFactory.e.d(null, this.f.getResources().getString(R.string.obfuscated_res_0x7f0f0f84)));
            this.W.setVisibility(8);
        }
    }

    public View H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.o : (View) invokeV.objValue;
    }

    public void H0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, str, z) == null) {
            if (z) {
                Z(NoDataViewFactory.e.d("", str));
            } else {
                Z(NoDataViewFactory.e.d(str, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f84)));
            }
            this.W.setVisibility(8);
        }
    }

    public ListView I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.d : (ListView) invokeV.objValue;
    }

    public void I0(fr4.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, cVar, z) == null) {
            fr4 fr4Var = this.M;
            if (fr4Var != null) {
                fr4Var.e();
                this.M = null;
            }
            fr4 fr4Var2 = new fr4(this.f.getPageContext().getPageActivity());
            this.M = fr4Var2;
            if (z) {
                fr4Var2.j(new String[]{this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f1054)}, cVar);
            } else {
                fr4Var2.j(new String[]{this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f1054), this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f1055)}, cVar);
            }
            this.M.c(this.f.getPageContext());
            this.M.m();
        }
    }

    public View J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.G : (View) invokeV.objValue;
    }

    public final void J0(SparseArray<Object> sparseArray) {
        NewSubPbActivity newSubPbActivity;
        AntiData l0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, sparseArray) == null) || (newSubPbActivity = this.f) == null || sparseArray == null || this.c == null) {
            return;
        }
        if (this.i0 == null) {
            this.i0 = new lj5(newSubPbActivity.getPageContext(), this.c);
        }
        SparseArray<String> sparseArray2 = new SparseArray<>();
        SubPbModel subPbModel = this.f0;
        if (subPbModel != null && (l0 = subPbModel.l0()) != null && l0.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = l0.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        lp4 lp4Var = new lp4();
        lp4Var.j(sparseArray2);
        this.i0.y(new String[]{this.f.getString(R.string.obfuscated_res_0x7f0f04b2), this.f.getString(R.string.obfuscated_res_0x7f0f04b3), this.f.getString(R.string.obfuscated_res_0x7f0f04b4), this.f.getString(R.string.obfuscated_res_0x7f0f04b5), this.f.getString(R.string.obfuscated_res_0x7f0f04b6)});
        this.i0.x(lp4Var);
        this.i0.A("4");
        this.i0.z(new p(this, sparseArray));
    }

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            NavigationBar navigationBar = this.k;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.d.setNextPage(this.B);
            this.B.Q();
        }
    }

    public wu7 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.c0 : (wu7) invokeV.objValue;
    }

    public void L0(zr7 zr7Var, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int i5;
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{zr7Var, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || zr7Var == null) {
            return;
        }
        if (this.h0 && (view2 = this.c) != null) {
            view2.setVisibility(8);
            this.d.removeHeaderView(this.c);
            this.d0 = 1;
        }
        this.U = zr7Var;
        if (zr7Var.i() != null) {
            this.U.i().f0 = true;
        }
        View view3 = this.c;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.n.setText(R.string.obfuscated_res_0x7f0f1500);
        if (zr7Var.i() != null) {
            int B = zr7Var.i().B();
            this.S = B;
            if (B > 0) {
                this.k.setCenterTextTitle(String.format(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f11d7), Integer.valueOf(this.S)));
                NewSubPbActivity newSubPbActivity = this.f;
                if (newSubPbActivity != null) {
                    this.V.setText(newSubPbActivity.c3());
                }
            } else {
                this.k.setCenterTextTitle(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f0a26));
            }
            String str = this.f.t3() ? "PB" : null;
            if (zr7Var.i().R() != null) {
                this.z.setData(this.f.getPageContext(), zr7Var.i().R(), ti8.a("PB", "c0132", zr7Var.d().getId(), zr7Var.d().getName(), zr7Var.l().getId(), str));
            } else {
                this.z.setData(null, null, null);
            }
        }
        if (zr7Var.o()) {
            this.B.Q();
            this.k0.g(true);
        } else {
            this.B.f();
            this.k0.g(false);
        }
        ArrayList<PostData> k2 = zr7Var.k();
        this.T = k2;
        if (k2 == null || k2.size() <= t0) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            int size = this.T.size() - t0;
            m0(size);
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
            if (this.h0) {
                arrayList.add(0, new vx7());
            }
        } else {
            this.d.setNextPage(this.B);
        }
        wx7 wx7Var = new wx7();
        wx7Var.b(zr7Var.m());
        arrayList.add(0, wx7Var);
        if (this.h0) {
            arrayList.add(0, zr7Var.i());
        }
        NewSubPbActivity newSubPbActivity2 = this.f;
        if (newSubPbActivity2 != null && newSubPbActivity2.d3() != null) {
            this.n0.setVisibility(this.f.d3().O0() ? 0 : 8);
        }
        this.k0.e(this.U.l(), arrayList);
        y(zr7Var, zr7Var.i(), zr7Var.e(), zr7Var.f(), i2, z);
        if (i3 > 0) {
            this.d.setSelectionFromTop(i4, i5);
        } else if (z2 && !oi.isEmpty(this.f.d3().t0())) {
            String t02 = this.f.d3().t0();
            int i6 = 0;
            while (true) {
                if (i6 < arrayList.size()) {
                    if ((arrayList.get(i6) instanceof PostData) && t02.equals(((PostData) arrayList.get(i6)).J())) {
                        this.d.post(new g(this, i6));
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

    public ImageView M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.Y : (ImageView) invokeV.objValue;
    }

    public boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.k0.a() : invokeV.booleanValue;
    }

    public ImageView N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.X : (ImageView) invokeV.objValue;
    }

    public final void N0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, metaData) == null) || metaData == null) {
            return;
        }
        String name_show = metaData.getName_show();
        if (je5.b(name_show) + (!StringUtils.isNull(metaData.getSealPrefix()) ? oi.byteLength(metaData.getSealPrefix()) + 2 : 0) > 14) {
            String k2 = je5.k(name_show, 0, 14);
            if (k2.length() == name_show.length()) {
                name_show = k2;
            } else {
                name_show = k2 + StringHelper.STRING_MORE;
            }
        }
        if (!StringUtils.isNull(metaData.getSealPrefix())) {
            this.q.setText(S(metaData.getSealPrefix(), name_show));
        } else {
            this.q.setText(name_show);
        }
        if (metaData.getAlaUserData() != null && this.r != null) {
            if (metaData.getAlaUserData().anchor_live == 0) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                uk4 uk4Var = new uk4();
                uk4Var.a = metaData.getAlaUserData();
                uk4Var.b = 4;
                this.r.setTag(uk4Var);
            }
        }
        if (metaData.isBigV()) {
            SkinManager.setViewTextColor(this.q, (int) R.color.cp_cont_r);
        } else if (UbsABTestHelper.isPBPlanA()) {
            vr4.d(this.q).v(R.color.CAM_X0108);
        } else {
            vr4.d(this.q).v(R.color.CAM_X0106);
        }
        this.p.setVisibility(0);
        this.p.setUserId(metaData.getUserId());
        this.p.setUserName(metaData.getUserName());
        this.p.setDefaultResource(R.drawable.obfuscated_res_0x7f0811a8);
        UtilHelper.showHeadImageViewBigV(this.p, metaData);
        this.p.J(metaData.getAvater(), 28, false);
        this.o.setTag(R.id.obfuscated_res_0x7f091f41, metaData.getUserId());
        this.o.setTag(R.id.obfuscated_res_0x7f091f49, metaData.getUserName());
        this.o.setTag(R.id.obfuscated_res_0x7f091f4b, metaData.getVirtualUserUrl());
    }

    public MorePopupWindow O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.D : (MorePopupWindow) invokeV.objValue;
    }

    public void O0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (bdTypeListView = this.d) == null) {
            return;
        }
        this.e0 = bdTypeListView.getLastVisiblePosition();
    }

    public TextView P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.V : (TextView) invokeV.objValue;
    }

    public void P0(boolean z) {
        wu7 wu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || (wu7Var = this.c0) == null || wu7Var.A() == null) {
            return;
        }
        if (z) {
            this.c0.A().setText(R.string.obfuscated_res_0x7f0f0f9c);
        } else {
            this.c0.A().setText(R.string.obfuscated_res_0x7f0f0a6c);
        }
    }

    public TextView Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.v : (TextView) invokeV.objValue;
    }

    public View R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder S(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048610, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new ux5.a(str, R.drawable.pic_smalldot_title));
            return ux5.h(this.f.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void T() {
        bu4 bu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (bu4Var = this.A) == null) {
            return;
        }
        bu4Var.h(false);
    }

    public void U() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (noDataView = this.h) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.d.setVisibility(0);
        this.W.setVisibility(0);
        this.a.setOnTouchListener(null);
    }

    public void V() {
        s35 s35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.V == null || (s35Var = this.R) == null) {
            return;
        }
        if (s35Var.w()) {
            this.V.setText(R.string.obfuscated_res_0x7f0f050c);
        } else {
            this.V.setText(this.f.c3());
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091e61);
            this.o = linearLayout;
            linearLayout.setOnClickListener(this.L);
            HeadImageView headImageView = (HeadImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0918a9);
            this.p = headImageView;
            headImageView.setRadius(pi.f(this.f.getActivity(), R.dimen.tbds45));
            this.p.setClickable(false);
            this.q = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09232f);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09233e);
            this.s = imageView;
            imageView.setVisibility(8);
            this.t = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0909b8);
            this.u = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092093);
            EllipsizeRichTextView ellipsizeRichTextView = (EllipsizeRichTextView) this.c.findViewById(R.id.obfuscated_res_0x7f0906bc);
            this.v = ellipsizeRichTextView;
            ellipsizeRichTextView.setOnClickListener(this.L);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0105);
            this.v.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            this.v.setLineSpacing(0.0f, 1.25f);
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091e51);
            this.w = tbImageView;
            tbImageView.setOnClickListener(this.L);
            this.y = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09013e);
            this.x = (PlayVoiceBntNew) this.c.findViewById(R.id.obfuscated_res_0x7f092480);
            this.c.setOnTouchListener(this.q0);
            this.c.setOnClickListener(this.L);
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.p0.setTag(this.o0);
            MessageManager.getInstance().registerListener(this.p0);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            int f2 = pi.f(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070306);
            int f3 = pi.f(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d4);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f092439);
            this.k = navigationBar;
            this.m = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new i(this));
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
            vr4 d2 = vr4.d(textView);
            d2.v(R.color.CAM_X0304);
            d2.z(R.dimen.T_X07);
            d2.A(R.string.F_X01);
            this.k.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.n, (View.OnClickListener) null);
            ViewCommonUtil.setViewMarginByDimen(this.n, -1, -1, R.dimen.M_W_X007, -1);
            this.n.setOnClickListener(this.L);
        }
    }

    public final void Z(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f83), this.i));
            if (this.h == null) {
                Activity pageActivity = this.f.getPageContext().getPageActivity();
                this.h = NoDataViewFactory.a(pageActivity, this.j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, pi.f(pageActivity, R.dimen.obfuscated_res_0x7f070288)), eVar, a2);
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

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
        }
    }

    public void a0(s35 s35Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, s35Var) == null) || s35Var == null || s35Var.a() == null) {
            return;
        }
        this.R = s35Var;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.j.addView(s35Var.a(), layoutParams);
        this.R.R(new c(this));
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.a.e() : invokeV.booleanValue;
    }

    public final boolean c0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048621, this, z)) == null) {
            SubPbModel subPbModel = this.f0;
            if (subPbModel == null || subPbModel.n0() == null) {
                return false;
            }
            if (this.f0.F0() != 0) {
                return false;
            }
            zr7 zr7Var = this.U;
            return (zr7Var == null || zr7Var.l() == null || this.U.l().getAuthor() == null || !TextUtils.equals(this.U.l().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
        }
        return invokeZ.booleanValue;
    }

    public void d0() {
        px7 px7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (px7Var = this.k0) == null) {
            return;
        }
        px7Var.c();
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            SubPbView subPbView = this.a;
            if (subPbView != null) {
                subPbView.f();
            }
            s35 s35Var = this.R;
            if (s35Var != null) {
                s35Var.D();
            }
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
        }
    }

    public void h0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.f.getLayoutMode().k(i2 == 1);
            this.f.getLayoutMode().j(this.a);
            this.f.getLayoutMode().j(this.c);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            this.k.onChangeSkinType(this.f.getPageContext(), i2);
            SubPbModel subPbModel = this.f0;
            if (subPbModel != null && (subPbModel.N0() || this.f0.K0())) {
                WebPManager.setPureDrawable(this.l, R.drawable.obfuscated_res_0x7f0809df, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.l, R.drawable.obfuscated_res_0x7f0809d0, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            TextView textView = this.n;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0304);
            }
            this.g.d(this.f.getPageContext(), i2);
            this.f.getLayoutMode().j(this.G);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0105);
            this.v.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            s35 s35Var = this.R;
            if (s35Var != null && s35Var.a() != null) {
                this.R.a().w(i2);
            }
            this.B.d(i2);
            this.x.e();
            SkinManager.setViewTextColor(this.V, (int) R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0302);
            if (UbsABTestHelper.isPBPlanA()) {
                vr4.d(this.q).A(R.string.F_X02);
                vr4.d(this.q).v(R.color.CAM_X0108);
            } else {
                vr4.d(this.q).A(R.string.F_X01);
                SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0106);
            }
            this.V.setAlpha(0.95f);
            if (this.C != null) {
                ha5.a(this.f.getPageContext(), this.C);
            }
            px7 px7Var = this.k0;
            if (px7Var != null) {
                px7Var.c();
            }
            this.f.getLayoutMode().j(this.E);
            SkinManager.setBackgroundColor(this.b0, R.color.CAM_X0203);
            WebPManager.setPureDrawable(this.a0, R.drawable.obfuscated_res_0x7f08097a, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            this.Z.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(pi.f(this.f, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            vr4.d(this.W).f(R.color.CAM_X0208);
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048627, this) != null) || this.f.w3()) {
        }
    }

    public void j0(int i2, String str, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091ef3, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091ef5, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091f10, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091ef4, Boolean.valueOf(z));
            int i4 = (i3 != 1002 || z) ? R.string.obfuscated_res_0x7f0f0493 : R.string.obfuscated_res_0x7f0f0fbc;
            if (i2 == 0) {
                i4 = (i3 != 1002 || z) ? R.string.obfuscated_res_0x7f0f049c : R.string.obfuscated_res_0x7f0f0fc0;
            }
            dr4 dr4Var = new dr4(this.f.getPageContext().getPageActivity());
            this.K = dr4Var;
            dr4Var.setMessageId(i4);
            this.K.setYesButtonTag(sparseArray);
            this.K.setPositiveButton(R.string.obfuscated_res_0x7f0f04e1, new n(this, sparseArray));
            this.K.setNegativeButton(R.string.obfuscated_res_0x7f0f04dc, new o(this));
            this.K.setCancelable(true);
            this.K.create(this.f.getPageContext());
            if (z2) {
                this.K.show();
            } else if (z) {
                this.K.show();
            } else if (1 == this.f0.p0()) {
                nj5 nj5Var = new nj5(this.f0.p0(), this.f0.o0(), this.f0.s0());
                nj5Var.i(this.U.d().getId(), this.U.d().getName());
                nj5Var.h(this.f0.q0());
                nj5Var.j(this.f0.G0());
                UserData userData = new UserData();
                userData.setIsManager(this.f0.u0());
                F0(sparseArray, nj5Var, userData);
            } else {
                J0(sparseArray);
            }
        }
    }

    public void k0(SparseArray<Object> sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048629, this, sparseArray, z) == null) {
            boolean z2 = true;
            if (this.J == null) {
                Dialog dialog = new Dialog(this.f.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a3);
                this.J = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.J.setCancelable(true);
                this.E = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02b1, (ViewGroup) null);
                this.f.getLayoutMode().j(this.E);
                this.J.setContentView(this.E);
                WindowManager.LayoutParams attributes = this.J.getWindow().getAttributes();
                attributes.width = (int) (pi.k(this.f.getPageContext().getPageActivity()) * 0.9d);
                this.J.getWindow().setAttributes(attributes);
            }
            TextView textView = (TextView) this.J.findViewById(R.id.obfuscated_res_0x7f090746);
            TextView textView2 = (TextView) this.J.findViewById(R.id.obfuscated_res_0x7f0909eb);
            TextView textView3 = (TextView) this.J.findViewById(R.id.obfuscated_res_0x7f09079a);
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091eed) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091eed)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ef3)) && intValue != 2) {
                SparseArray sparseArray2 = (SparseArray) textView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    textView.setTag(sparseArray2);
                }
                textView.setVisibility(0);
                sparseArray2.put(R.id.obfuscated_res_0x7f091ef3, sparseArray.get(R.id.obfuscated_res_0x7f091ef3));
                sparseArray2.put(R.id.obfuscated_res_0x7f091ef5, sparseArray.get(R.id.obfuscated_res_0x7f091ef5));
                sparseArray2.put(R.id.obfuscated_res_0x7f091ef4, sparseArray.get(R.id.obfuscated_res_0x7f091ef4));
                sparseArray2.put(R.id.obfuscated_res_0x7f091f10, sparseArray.get(R.id.obfuscated_res_0x7f091f10));
                textView.setOnClickListener(new k(this));
            } else {
                textView.setVisibility(8);
            }
            if ("".equals(sparseArray.get(R.id.obfuscated_res_0x7f091efe)) && "".equals(sparseArray.get(R.id.obfuscated_res_0x7f091eff))) {
                textView2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) textView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    textView2.setTag(sparseArray3);
                }
                textView2.setVisibility(0);
                sparseArray3.put(R.id.obfuscated_res_0x7f091efe, sparseArray.get(R.id.obfuscated_res_0x7f091efe));
                sparseArray3.put(R.id.obfuscated_res_0x7f091eff, sparseArray.get(R.id.obfuscated_res_0x7f091eff));
                sparseArray3.put(R.id.obfuscated_res_0x7f091f00, sparseArray.get(R.id.obfuscated_res_0x7f091f00));
                sparseArray3.put(R.id.obfuscated_res_0x7f091f10, sparseArray.get(R.id.obfuscated_res_0x7f091f10));
                sparseArray3.put(R.id.obfuscated_res_0x7f091f01, sparseArray.get(R.id.obfuscated_res_0x7f091f01));
                textView2.setOnClickListener(new l(this));
            }
            if (!(((sparseArray.get(R.id.obfuscated_res_0x7f091f48) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091f48)).booleanValue()) ? false : false)) {
                textView3.setVisibility(8);
            } else {
                SparseArray sparseArray4 = (SparseArray) textView3.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    textView3.setTag(sparseArray4);
                }
                textView3.setVisibility(0);
                if (z) {
                    textView3.setText(R.string.obfuscated_res_0x7f0f1459);
                } else {
                    textView3.setText(R.string.obfuscated_res_0x7f0f0b0b);
                }
                sparseArray4.put(R.id.obfuscated_res_0x7f091f08, sparseArray.get(R.id.obfuscated_res_0x7f091f08));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f44, sparseArray.get(R.id.obfuscated_res_0x7f091f44));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f45, sparseArray.get(R.id.obfuscated_res_0x7f091f45));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f46, sparseArray.get(R.id.obfuscated_res_0x7f091f46));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f47, sparseArray.get(R.id.obfuscated_res_0x7f091f47));
                sparseArray4.put(R.id.obfuscated_res_0x7f091f43, sparseArray.get(R.id.obfuscated_res_0x7f091f43));
                textView3.setOnClickListener(new m(this, z));
            }
            sg.j(this.J, this.f.getPageContext());
        }
    }

    public void l0(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        k0(sparseArray, false);
    }

    public final void m0(int i2) {
        ArrayList<PostData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048631, this, i2) == null) || (arrayList = this.T) == null) {
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

    public void n0(NewSubPbActivity.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, r0Var) == null) {
            this.Q = r0Var;
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            this.d.setVisibility(0);
            this.O.setVisibility(8);
            this.B.f();
        }
    }

    public void p0(NewSubPbActivity.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, r0Var) == null) {
            this.P = r0Var;
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.h0 = z;
        }
    }

    public void r(boolean z) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048636, this, z) == null) || (subPbModel = this.f0) == null || !subPbModel.M0() || z) {
            return;
        }
        this.k.setIsClose(true);
        this.k.setIsCorner(true);
        this.k.isShowBottomLine(true);
        this.k.setBottomLineHeight(3);
        this.k.setStatusBarVisibility(8);
        this.H = new BlankView(this.f.getPageContext().getPageActivity());
        if (this.f0.N0()) {
            this.g0 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds562) + UtilHelper.getStatusBarHeight();
        } else {
            this.g0 = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070252);
        }
        this.b.addView(this.H, 0, new LinearLayout.LayoutParams(-1, this.g0));
        this.H.setVisibility(0);
        this.H.setOnClickListener(new f(this));
        this.a.setBlankView(this.H);
    }

    public void r0(gu4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, gVar) == null) {
            this.m0 = gVar;
            vz7 vz7Var = this.e;
            if (vz7Var != null) {
                vz7Var.f(gVar);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            y0(this.f);
            this.d.setNextPage(this.B);
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.d.setVisibility(0);
            this.O.setVisibility(8);
            this.B.R();
        }
    }

    public void t() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || this.f0 == null) {
            return;
        }
        if ((!M0() && (view2 = this.G) != null && view2.isShown()) || ListUtils.isEmpty(this.T)) {
            this.f0.c1(false);
        } else {
            this.f0.c1(true);
        }
    }

    public void t0(SubPbModel subPbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, subPbModel) == null) {
            this.f0 = subPbModel;
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
    public void u(PostData postData, int i2, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048642, this, postData, i2, sparseArray) == null) || postData == null) {
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
        zr7 zr7Var = this.U;
        if (zr7Var != null && zr7Var.l() != null && this.U.l().getAuthor() != null && postData.s() != null) {
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
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f10, Integer.valueOf(i2));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f01, postData.J());
                        if (postData.s() != null) {
                            sparseArray2.put(R.id.obfuscated_res_0x7f091efe, postData.s().getUserName());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091eff, postData.s().getName_show());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091f00, postData.s().getPortrait());
                        }
                        z5 = true;
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091efe, "");
                        sparseArray2.put(R.id.obfuscated_res_0x7f091eff, "");
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f00, "");
                        z5 = false;
                    }
                    if (z2) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f10, Integer.valueOf(i2));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ef4, Boolean.TRUE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ef5, Integer.valueOf(i3));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ef3, postData.J());
                        z5 = true;
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ef4, Boolean.FALSE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ef5, 0);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ef3, "");
                    }
                    sparseArray2.put(R.id.obfuscated_res_0x7f091f34, Boolean.valueOf(z5));
                    sparseArray2.put(R.id.obfuscated_res_0x7f091f01, postData.J());
                    if (z) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f34, Boolean.TRUE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f10, Integer.valueOf(i2));
                        if (postData.s() != null) {
                            sparseArray2.put(R.id.obfuscated_res_0x7f091efe, postData.s().getUserName());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091eff, postData.s().getName_show());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091f00, postData.s().getPortrait());
                        }
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f34, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f48, Boolean.TRUE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f08, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.s() != null) {
                            sparseArray2.put(R.id.obfuscated_res_0x7f091f44, postData.s().getUserId());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091f45, postData.s().getUserName());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091f43, postData.s().getName_show());
                        }
                        if (this.U.l() != null) {
                            sparseArray2.put(R.id.obfuscated_res_0x7f091f47, this.U.l().getId());
                        }
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f46, postData.J());
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f48, Boolean.FALSE);
                    }
                    if (z2) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f32, Boolean.TRUE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f10, Integer.valueOf(i2));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ef4, Boolean.valueOf(z4));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ef5, Integer.valueOf(i3));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ef3, postData.J());
                        sparseArray2.put(R.id.obfuscated_res_0x7f091f05, Boolean.valueOf(postData.g0()));
                        return;
                    }
                    sparseArray2.put(R.id.obfuscated_res_0x7f091f32, Boolean.FALSE);
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
                sparseArray2.put(R.id.obfuscated_res_0x7f091f34, Boolean.valueOf(z5));
                sparseArray2.put(R.id.obfuscated_res_0x7f091f01, postData.J());
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
        sparseArray2.put(R.id.obfuscated_res_0x7f091f34, Boolean.valueOf(z5));
        sparseArray2.put(R.id.obfuscated_res_0x7f091f01, postData.J());
        if (z) {
        }
        if (z3) {
        }
        if (z2) {
        }
    }

    public void u0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, yVar) == null) {
            this.k0.i(yVar);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            MorePopupWindow morePopupWindow = this.D;
            if (morePopupWindow != null) {
                sg.d(morePopupWindow, this.f.getPageContext().getPageActivity());
            }
            fr4 fr4Var = this.F;
            if (fr4Var != null) {
                fr4Var.e();
            }
            dr4 dr4Var = this.K;
            if (dr4Var != null) {
                dr4Var.dismiss();
            }
            Dialog dialog = this.J;
            if (dialog != null) {
                sg.b(dialog, this.f.getPageContext());
            }
            ProgressBar progressBar = this.O;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            wu7 wu7Var = this.c0;
            if (wu7Var != null) {
                wu7Var.dismiss();
            }
        }
    }

    public void v0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, onLongClickListener) == null) {
            this.k0.h(onLongClickListener);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", u0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void w0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    public final void x(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048648, this, z) == null) || (bdTypeListView = this.d) == null) {
            return;
        }
        if (!z) {
            bdTypeListView.setEnabled(z);
        } else {
            bdTypeListView.postDelayed(new b(this, z), 10L);
        }
    }

    public void x0(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, onScrollListener) == null) {
            this.d.setOnScrollListener(onScrollListener);
        }
    }

    public void y(zr7 zr7Var, PostData postData, boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048650, this, new Object[]{zr7Var, postData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) || postData == null || this.h0) {
            return;
        }
        if (!StringUtils.isNull(postData.A())) {
            this.w.setVisibility(0);
            this.w.J(postData.A(), 10, true);
        } else {
            this.w.setVisibility(8);
        }
        hi8 w = postData.w();
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
        sparseArray.put(R.id.obfuscated_res_0x7f091ef1, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091f0a, Boolean.FALSE);
        u(postData, i2, sparseArray);
        this.q.setText((CharSequence) null);
        this.t.setVisibility(8);
        if (!this.h0) {
            N0(postData.s());
            if (z) {
                this.t.setVisibility(0);
                SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0302);
            }
        }
        this.u.setText(StringHelper.getFormatTime(postData.Y()));
        postData.s().getUserTbVipInfoData();
        boolean C0 = C0(this.v, postData.Q());
        if (StringUtils.isNull(postData.A()) && !C0 && postData.e0() != null) {
            this.x.setVisibility(0);
            this.x.setTag(postData.e0());
            return;
        }
        this.x.setVisibility(8);
    }

    public void y0(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, pVar) == null) {
            this.d.setOnSrollToBottomListener(pVar);
        }
    }

    public void z(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048652, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            ProgressBar progressBar = this.O;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (z && z2) {
                NewSubPbActivity newSubPbActivity = this.f;
                newSubPbActivity.showToast(newSubPbActivity.getResources().getString(R.string.obfuscated_res_0x7f0f04ac));
            } else if (str == null || !z2) {
            } else {
                this.f.showToast(str);
            }
        }
    }

    public void z0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, bdUniqueId) == null) {
            this.o0 = bdUniqueId;
            X();
        }
    }
}
