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
import com.baidu.tbadk.core.util.StringHelper;
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
import com.repackage.bi5;
import com.repackage.cr4;
import com.repackage.cu4;
import com.repackage.dt7;
import com.repackage.er4;
import com.repackage.ex5;
import com.repackage.fk8;
import com.repackage.hy7;
import com.repackage.yh5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class gy7 implements KeyboardEventLayout.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int r0;
    public transient /* synthetic */ FieldHolder $fh;
    public xt4 A;
    public jy7 B;
    public View C;
    public MorePopupWindow D;
    public View E;
    public er4 F;
    public View G;
    public BlankView H;
    public View I;
    public Dialog J;
    public cr4 K;
    public View.OnClickListener L;
    public er4 M;
    public boolean N;
    public ProgressBar O;
    public NewSubPbActivity.r0 P;
    public NewSubPbActivity.r0 Q;
    public p25 R;
    public int S;
    public ArrayList<PostData> T;
    public rs7 U;
    public TextView V;
    public RelativeLayout W;
    public ImageView X;
    public ImageView Y;
    public LinearLayout Z;
    public SubPbView a;
    public HeadImageView a0;
    public LinearLayout b;
    public View b0;
    public View c;
    public pv7 c0;
    public BdTypeListView d;
    public int d0;
    public o08 e;
    public int e0;
    public NewSubPbActivity f;
    public SubPbModel f0;
    public NoNetworkView g;
    public int g0;
    public NoDataView h;
    public boolean h0;
    public View.OnClickListener i;
    public yh5 i0;
    public RelativeLayout j;
    public bi5 j0;
    public NavigationBar k;
    public iy7 k0;
    public ImageView l;
    public boolean l0;
    public View m;
    public cu4.g m0;
    public TextView n;
    public MaskView n0;
    public LinearLayout o;
    public dt7 o0;
    public HeadImageView p;
    public AdapterView.OnItemLongClickListener p0;
    public TextView q;
    public AdapterView.OnItemClickListener q0;
    public View r;
    public ImageView s;
    public TextView t;
    public TextView u;
    public EllipsizeRichTextView v;
    public TbImageView w;
    public PlayVoiceBntNew x;
    public TextView y;
    public ThreadSkinView z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ gy7 b;

        public a(gy7 gy7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gy7Var;
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
    public class b implements fk8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy7 a;

        public b(gy7 gy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gy7Var;
        }

        @Override // com.repackage.fk8.f
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                this.a.U();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy7 a;

        public c(gy7 gy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gy7Var;
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
                        this.a.c0 = new pv7(this.a.f.getPageContext(), this.a.L);
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
                    PostData postData2 = sparseArray.get(R.id.obfuscated_res_0x7f091e56) instanceof PostData ? (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e56) : null;
                    boolean z = this.a.a0(sparseArray.get(R.id.obfuscated_res_0x7f091e59) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                    this.a.c0.q(sparseArray, this.a.f0.D0(), z, this.a.l0 && postData2 != null && postData2.l0, this.a.f0.l0());
                    if (z) {
                        this.a.c0.D().setVisibility(0);
                        this.a.c0.D().setTag(postData.I());
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
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy7 a;

        public d(gy7 gy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gy7Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.f != null && ViewHelper.checkUpIsLogin(this.a.f.getPageContext().getPageActivity())) {
                if ((this.a.f.mReplyPrivacyController != null && this.a.f0 != null && this.a.f0.j0() != null && !this.a.f.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.a.f0.j0().replyPrivateFlag)) || this.a.f0 == null || this.a.R == null) {
                    return;
                }
                this.a.L0();
                if (view2 != null && (view2.getTag() instanceof hy7.a)) {
                    this.a.s();
                    this.a.f0.e1();
                    return;
                }
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091e86);
                    String str2 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091e85);
                    String str3 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091e84);
                    if (str != null) {
                        this.a.R.W(str2);
                        this.a.R.V(str, str3);
                    }
                }
                this.a.u();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy7 a;

        public e(gy7 gy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gy7Var;
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
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ gy7 b;

        public f(gy7 gy7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gy7Var;
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
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy7 a;

        public g(gy7 gy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f0 == null || (!this.a.f0.L0() && !this.a.f0.I0())) {
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
    public class h implements dt7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy7 a;

        public h(gy7 gy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gy7Var;
        }

        @Override // com.repackage.dt7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
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
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy7 a;

        public i(gy7 gy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.J != null && (this.a.J instanceof Dialog)) {
                    rg.b(this.a.J, this.a.f.getPageContext());
                }
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                this.a.h0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e5a)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e58), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e75)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e59)).booleanValue(), false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy7 a;

        public j(gy7 gy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.J != null && (this.a.J instanceof Dialog)) {
                    rg.b(this.a.J, this.a.f.getPageContext());
                }
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null || this.a.P == null) {
                    return;
                }
                this.a.P.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f091e75), sparseArray.get(R.id.obfuscated_res_0x7f091e63), sparseArray.get(R.id.obfuscated_res_0x7f091e66), sparseArray.get(R.id.obfuscated_res_0x7f091e64), sparseArray.get(R.id.obfuscated_res_0x7f091e65)});
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ gy7 b;

        public k(gy7 gy7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gy7Var;
            this.a = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.J != null && (this.b.J instanceof Dialog)) {
                    rg.b(this.b.J, this.b.f.getPageContext());
                }
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                this.b.f.handleMuteClick(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f091ea7), sparseArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ gy7 b;

        public l(gy7 gy7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gy7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                if (this.b.Q != null) {
                    this.b.Q.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f091e58), this.a.get(R.id.obfuscated_res_0x7f091e75), this.a.get(R.id.obfuscated_res_0x7f091e59), this.a.get(R.id.obfuscated_res_0x7f091e5a)});
                }
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(gy7 gy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var};
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

    /* loaded from: classes6.dex */
    public class n implements yh5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ gy7 b;

        public n(gy7 gy7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gy7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.yh5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.b.Q != null) {
                    this.b.Q.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f091e58), this.a.get(R.id.obfuscated_res_0x7f091e75), this.a.get(R.id.obfuscated_res_0x7f091e59), this.a.get(R.id.obfuscated_res_0x7f091e5a), JsonArrayToString});
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements bi5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ gy7 b;

        public o(gy7 gy7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gy7Var;
            this.a = sparseArray;
        }

        @Override // com.repackage.bi5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.b.Q != null) {
                    this.b.Q.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f091e58), this.a.get(R.id.obfuscated_res_0x7f091e75), this.a.get(R.id.obfuscated_res_0x7f091e59), this.a.get(R.id.obfuscated_res_0x7f091e5a), JsonArrayToString});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755661620, "Lcom/repackage/gy7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755661620, "Lcom/repackage/gy7;");
                return;
            }
        }
        r0 = TbadkCoreApplication.getInst().getListItemRule().c();
    }

    public gy7(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
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
        this.o0 = new dt7(new h(this));
        this.p0 = new c(this);
        this.q0 = new d(this);
        this.f = newSubPbActivity;
        this.L = onClickListener;
        this.a = (SubPbView) LayoutInflater.from(newSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0609, (ViewGroup) null);
        this.c = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0608, (ViewGroup) null);
        this.b = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091518);
        this.W = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091dbe);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091dc1);
        this.V = textView;
        textView.setOnClickListener(this.L);
        this.X = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091dc4);
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091dc3);
        this.Y = imageView;
        imageView.setOnClickListener(this.L);
        this.X.setOnClickListener(this.L);
        this.g = (NoNetworkView) this.a.findViewById(R.id.obfuscated_res_0x7f0923ae);
        W();
        V();
        this.j = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091daf);
        this.d = (BdTypeListView) this.a.findViewById(R.id.obfuscated_res_0x7f091558);
        ThreadSkinView threadSkinView = (ThreadSkinView) LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d082d, (ViewGroup) null);
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
        jy7 jy7Var = new jy7(this.f.getPageContext());
        this.B = jy7Var;
        jy7Var.x();
        this.G = this.B.b();
        this.d.setNextPage(this.B);
        this.B.B(this.L);
        this.d.setOnItemClickListener(this.q0);
        this.d.setOnItemLongClickListener(this.p0);
        this.d.setOnTouchListener(this.o0);
        o08 o08Var = new o08(newSubPbActivity.getPageContext());
        this.e = o08Var;
        o08Var.n();
        this.e.f(this.m0);
        this.e.H(TbadkCoreApplication.getInst().getSkinType());
        this.O = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f09191d);
        this.n0 = (MaskView) this.a.findViewById(R.id.obfuscated_res_0x7f0913ab);
        this.b0 = this.a.findViewById(R.id.obfuscated_res_0x7f092394);
        this.Z = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09169c);
        HeadImageView headImageView = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0916a5);
        this.a0 = headImageView;
        headImageView.setVisibility(0);
        this.a0.setIsRound(true);
        this.a0.setBorderWidth(oi.f(this.f, R.dimen.L_X01));
        this.a0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.a0.setDefaultBgResource(0);
        this.a0.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.a0.K(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        f0(TbadkCoreApplication.getInst().getSkinType());
        View view2 = this.c;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View a2 = xk4.b().a(this.f.getActivity(), 4);
        this.r = a2;
        if (a2 != null) {
            a2.setVisibility(8);
            this.o.addView(this.r, 3);
        }
        iy7 iy7Var = new iy7(this.f, this.d);
        this.k0 = iy7Var;
        iy7Var.f(this.N);
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

    public void A0(PostData postData) {
        int i2;
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData) == null) || postData == null) {
            return;
        }
        postData.w0(true);
        PostData postData2 = new PostData();
        postData2.A0(52);
        if (!J0() && (view2 = this.G) != null && view2.isShown()) {
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

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.A == null) {
                this.A = new xt4(this.f.getPageContext());
            }
            this.A.h(true);
        }
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            p25 p25Var = this.R;
            if (p25Var == null || p25Var.a() == null) {
                return 0;
            }
            return this.R.a().getHeight();
        }
        return invokeV.intValue;
    }

    public final void C0(SparseArray<Object> sparseArray, ai5 ai5Var, UserData userData) {
        NewSubPbActivity newSubPbActivity;
        AntiData j0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, sparseArray, ai5Var, userData) == null) || (newSubPbActivity = this.f) == null || sparseArray == null || this.c == null) {
            return;
        }
        if (this.j0 == null) {
            this.j0 = new bi5(newSubPbActivity.getPageContext(), this.c, ai5Var, userData);
        }
        SparseArray<String> sparseArray2 = new SparseArray<>();
        SubPbModel subPbModel = this.f0;
        if (subPbModel != null && (j0 = subPbModel.j0()) != null && j0.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = j0.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        lp4 lp4Var = new lp4();
        lp4Var.j(sparseArray2);
        this.j0.E(new String[]{this.f.getString(R.string.obfuscated_res_0x7f0f04a9), this.f.getString(R.string.obfuscated_res_0x7f0f04aa), this.f.getString(R.string.obfuscated_res_0x7f0f04ab), this.f.getString(R.string.obfuscated_res_0x7f0f04ac), this.f.getString(R.string.obfuscated_res_0x7f0f04ad)});
        this.j0.D(lp4Var);
        this.j0.G("4");
        this.j0.F(new o(this, sparseArray));
    }

    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.w : (View) invokeV.objValue;
    }

    public void D0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            X(NoDataViewFactory.e.d(null, this.f.getResources().getString(R.string.obfuscated_res_0x7f0f0f69)));
            this.W.setVisibility(8);
        }
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public void E0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) {
            if (z) {
                X(NoDataViewFactory.e.d("", str));
            } else {
                X(NoDataViewFactory.e.d(str, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f69)));
            }
            this.W.setVisibility(8);
        }
    }

    public View F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public void F0(er4.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, cVar, z) == null) {
            er4 er4Var = this.M;
            if (er4Var != null) {
                er4Var.e();
                this.M = null;
            }
            er4 er4Var2 = new er4(this.f.getPageContext().getPageActivity());
            this.M = er4Var2;
            if (z) {
                er4Var2.j(new String[]{this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f106e)}, cVar);
            } else {
                er4Var2.j(new String[]{this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f106e), this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f106f)}, cVar);
            }
            this.M.c(this.f.getPageContext());
            this.M.m();
        }
    }

    public View G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.o : (View) invokeV.objValue;
    }

    public final void G0(SparseArray<Object> sparseArray) {
        NewSubPbActivity newSubPbActivity;
        AntiData j0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, sparseArray) == null) || (newSubPbActivity = this.f) == null || sparseArray == null || this.c == null) {
            return;
        }
        if (this.i0 == null) {
            this.i0 = new yh5(newSubPbActivity.getPageContext(), this.c);
        }
        SparseArray<String> sparseArray2 = new SparseArray<>();
        SubPbModel subPbModel = this.f0;
        if (subPbModel != null && (j0 = subPbModel.j0()) != null && j0.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = j0.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        lp4 lp4Var = new lp4();
        lp4Var.j(sparseArray2);
        this.i0.y(new String[]{this.f.getString(R.string.obfuscated_res_0x7f0f04a9), this.f.getString(R.string.obfuscated_res_0x7f0f04aa), this.f.getString(R.string.obfuscated_res_0x7f0f04ab), this.f.getString(R.string.obfuscated_res_0x7f0f04ac), this.f.getString(R.string.obfuscated_res_0x7f0f04ad)});
        this.i0.x(lp4Var);
        this.i0.A("4");
        this.i0.z(new n(this, sparseArray));
    }

    public ListView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.d : (ListView) invokeV.objValue;
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.d.setNextPage(this.B);
            this.B.Q();
        }
    }

    public View I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.G : (View) invokeV.objValue;
    }

    public void I0(rs7 rs7Var, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int i5;
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{rs7Var, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || rs7Var == null) {
            return;
        }
        if (this.h0 && (view2 = this.c) != null) {
            view2.setVisibility(8);
            this.d.removeHeaderView(this.c);
            this.d0 = 1;
        }
        this.U = rs7Var;
        if (rs7Var.i() != null) {
            this.U.i().l0 = true;
        }
        View view3 = this.c;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.n.setText(R.string.obfuscated_res_0x7f0f150d);
        if (rs7Var.i() != null) {
            int A = rs7Var.i().A();
            this.S = A;
            if (A > 0) {
                this.k.setCenterTextTitle(String.format(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f11f2), Integer.valueOf(this.S)));
                NewSubPbActivity newSubPbActivity = this.f;
                if (newSubPbActivity != null) {
                    this.V.setText(newSubPbActivity.getReplyHint());
                }
            } else {
                this.k.setCenterTextTitle(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f0a3c));
            }
            String str = this.f.isFromPb() ? "PB" : null;
            if (rs7Var.i().Q() != null) {
                this.z.setData(this.f.getPageContext(), rs7Var.i().Q(), hl8.a("PB", "c0132", rs7Var.d().getId(), rs7Var.d().getName(), rs7Var.l().getId(), str));
            } else {
                this.z.setData(null, null, null);
            }
        }
        if (rs7Var.o()) {
            this.B.Q();
            this.k0.g(true);
        } else {
            this.B.f();
            this.k0.g(false);
        }
        ArrayList<PostData> k2 = rs7Var.k();
        this.T = k2;
        if (k2 == null || k2.size() <= r0) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            int size = this.T.size() - r0;
            k0(size);
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
                arrayList.add(0, new oy7());
            }
        } else {
            this.d.setNextPage(this.B);
        }
        py7 py7Var = new py7();
        py7Var.b(rs7Var.m());
        arrayList.add(0, py7Var);
        if (this.h0) {
            arrayList.add(0, rs7Var.i());
        }
        NewSubPbActivity newSubPbActivity2 = this.f;
        if (newSubPbActivity2 != null && newSubPbActivity2.getSubPbModel() != null) {
            this.n0.setVisibility(this.f.getSubPbModel().M0() ? 0 : 8);
        }
        this.k0.e(this.U.l(), arrayList);
        y(rs7Var, rs7Var.i(), rs7Var.e(), rs7Var.f(), i2, z);
        if (i3 > 0) {
            this.d.setSelectionFromTop(i4, i5);
        } else if (z2 && !ni.isEmpty(this.f.getSubPbModel().r0())) {
            String r02 = this.f.getSubPbModel().r0();
            int i6 = 0;
            while (true) {
                if (i6 < arrayList.size()) {
                    if ((arrayList.get(i6) instanceof PostData) && r02.equals(((PostData) arrayList.get(i6)).I())) {
                        this.d.post(new f(this, i6));
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

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            NavigationBar navigationBar = this.k;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.k0.a() : invokeV.booleanValue;
    }

    public pv7 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.c0 : (pv7) invokeV.objValue;
    }

    public final void K0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, metaData) == null) || metaData == null) {
            return;
        }
        String name_show = metaData.getName_show();
        if (fd5.b(name_show) + (!StringUtils.isNull(metaData.getSealPrefix()) ? ni.byteLength(metaData.getSealPrefix()) + 2 : 0) > 14) {
            String k2 = fd5.k(name_show, 0, 14);
            if (k2.length() == name_show.length()) {
                name_show = k2;
            } else {
                name_show = k2 + StringHelper.STRING_MORE;
            }
        }
        if (!StringUtils.isNull(metaData.getSealPrefix())) {
            this.q.setText(R(metaData.getSealPrefix(), name_show));
        } else {
            this.q.setText(name_show);
        }
        if (metaData.getAlaUserData() != null && this.r != null) {
            if (metaData.getAlaUserData().anchor_live == 0) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                wk4 wk4Var = new wk4();
                wk4Var.a = metaData.getAlaUserData();
                wk4Var.b = 4;
                this.r.setTag(wk4Var);
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
        this.p.setDefaultResource(R.drawable.obfuscated_res_0x7f08120b);
        UtilHelper.showHeadImageViewBigV(this.p, metaData);
        this.p.K(metaData.getAvater(), 28, false);
        this.o.setTag(R.id.obfuscated_res_0x7f091ea4, metaData.getUserId());
        this.o.setTag(R.id.obfuscated_res_0x7f091eac, metaData.getUserName());
        this.o.setTag(R.id.obfuscated_res_0x7f091eae, metaData.getVirtualUserUrl());
    }

    public ImageView L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.Y : (ImageView) invokeV.objValue;
    }

    public void L0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (bdTypeListView = this.d) == null) {
            return;
        }
        this.e0 = bdTypeListView.getLastVisiblePosition();
    }

    public ImageView M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.X : (ImageView) invokeV.objValue;
    }

    public void M0(boolean z) {
        pv7 pv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (pv7Var = this.c0) == null || pv7Var.A() == null) {
            return;
        }
        if (z) {
            this.c0.A().setText(R.string.obfuscated_res_0x7f0f0f84);
        } else {
            this.c0.A().setText(R.string.obfuscated_res_0x7f0f0a81);
        }
    }

    public MorePopupWindow N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.D : (MorePopupWindow) invokeV.objValue;
    }

    public TextView O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.V : (TextView) invokeV.objValue;
    }

    public TextView P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.v : (TextView) invokeV.objValue;
    }

    public View Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder R(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new ex5.a(str, R.drawable.pic_smalldot_title));
            return ex5.h(this.f.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void S() {
        xt4 xt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (xt4Var = this.A) == null) {
            return;
        }
        xt4Var.h(false);
    }

    public void T() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (noDataView = this.h) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.d.setVisibility(0);
        this.W.setVisibility(0);
        this.a.setOnTouchListener(null);
    }

    public void U() {
        p25 p25Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.V == null || (p25Var = this.R) == null) {
            return;
        }
        if (p25Var.w()) {
            this.V.setText(R.string.obfuscated_res_0x7f0f0507);
        } else {
            this.V.setText(this.f.getReplyHint());
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091dc5);
            this.o = linearLayout;
            linearLayout.setOnClickListener(this.L);
            HeadImageView headImageView = (HeadImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091824);
            this.p = headImageView;
            headImageView.setRadius(oi.f(this.f.getActivity(), R.dimen.tbds45));
            this.p.setClickable(false);
            this.q = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09229d);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0922ac);
            this.s = imageView;
            imageView.setVisibility(8);
            this.t = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0909e7);
            this.u = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091fe7);
            EllipsizeRichTextView ellipsizeRichTextView = (EllipsizeRichTextView) this.c.findViewById(R.id.obfuscated_res_0x7f0906ef);
            this.v = ellipsizeRichTextView;
            ellipsizeRichTextView.setOnClickListener(this.L);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0105);
            this.v.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            this.v.setLineSpacing(0.0f, 1.25f);
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091db0);
            this.w = tbImageView;
            tbImageView.setOnClickListener(this.L);
            this.y = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09014a);
            this.x = (PlayVoiceBntNew) this.c.findViewById(R.id.obfuscated_res_0x7f0923db);
            this.c.setOnTouchListener(this.o0);
            this.c.setOnClickListener(this.L);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            int f2 = oi.f(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070309);
            int f3 = oi.f(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d4);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f0923ac);
            this.k = navigationBar;
            this.m = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
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

    public final void X(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f68), this.i));
            if (this.h == null) {
                Activity pageActivity = this.f.getPageContext().getPageActivity();
                this.h = NoDataViewFactory.a(pageActivity, this.j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, oi.f(pageActivity, R.dimen.obfuscated_res_0x7f07028b)), eVar, a2);
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

    public void Y(p25 p25Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, p25Var) == null) || p25Var == null || p25Var.a() == null) {
            return;
        }
        this.R = p25Var;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.j.addView(p25Var.a(), layoutParams);
        this.R.R(new b(this));
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.a.e() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
        }
    }

    public final boolean a0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048616, this, z)) == null) {
            SubPbModel subPbModel = this.f0;
            if (subPbModel == null || subPbModel.l0() == null) {
                return false;
            }
            if (this.f0.D0() != 0) {
                return false;
            }
            rs7 rs7Var = this.U;
            return (rs7Var == null || rs7Var.l() == null || this.U.l().getAuthor() == null || !TextUtils.equals(this.U.l().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
        }
        return invokeZ.booleanValue;
    }

    public void b0() {
        iy7 iy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (iy7Var = this.k0) == null) {
            return;
        }
        iy7Var.c();
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            SubPbView subPbView = this.a;
            if (subPbView != null) {
                subPbView.f();
            }
            p25 p25Var = this.R;
            if (p25Var != null) {
                p25Var.D();
            }
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
        }
    }

    public void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            this.f.getLayoutMode().k(i2 == 1);
            this.f.getLayoutMode().j(this.a);
            this.f.getLayoutMode().j(this.c);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            this.k.onChangeSkinType(this.f.getPageContext(), i2);
            SubPbModel subPbModel = this.f0;
            if (subPbModel != null && (subPbModel.L0() || this.f0.I0())) {
                WebPManager.setPureDrawable(this.l, R.drawable.obfuscated_res_0x7f0809c7, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.l, R.drawable.obfuscated_res_0x7f0809ba, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            TextView textView = this.n;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0304);
            }
            this.g.c(this.f.getPageContext(), i2);
            this.f.getLayoutMode().j(this.G);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0105);
            this.v.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            p25 p25Var = this.R;
            if (p25Var != null && p25Var.a() != null) {
                this.R.a().w(i2);
            }
            this.B.d(i2);
            this.x.d();
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
                f95.a(this.f.getPageContext(), this.C);
            }
            iy7 iy7Var = this.k0;
            if (iy7Var != null) {
                iy7Var.c();
            }
            this.f.getLayoutMode().j(this.E);
            SkinManager.setBackgroundColor(this.b0, R.color.CAM_X0203);
            this.a0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.Z.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(oi.f(this.f, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            vr4.d(this.W).f(R.color.CAM_X0208);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || this.f.isPaused()) {
        }
    }

    public void h0(int i2, String str, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e5a, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e75, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(z));
            int i4 = (i3 != 1002 || z) ? R.string.obfuscated_res_0x7f0f048a : R.string.obfuscated_res_0x7f0f0fa5;
            if (i2 == 0) {
                i4 = (i3 != 1002 || z) ? R.string.obfuscated_res_0x7f0f0493 : R.string.obfuscated_res_0x7f0f0fa9;
            }
            cr4 cr4Var = new cr4(this.f.getPageContext().getPageActivity());
            this.K = cr4Var;
            cr4Var.setMessageId(i4);
            this.K.setYesButtonTag(sparseArray);
            this.K.setPositiveButton(R.string.obfuscated_res_0x7f0f04dd, new l(this, sparseArray));
            this.K.setNegativeButton(R.string.obfuscated_res_0x7f0f04d8, new m(this));
            this.K.setCancelable(true);
            this.K.create(this.f.getPageContext());
            if (z2) {
                this.K.show();
            } else if (z) {
                this.K.show();
            } else if (1 == this.f0.n0()) {
                ai5 ai5Var = new ai5(this.f0.n0(), this.f0.m0(), this.f0.q0());
                ai5Var.i(this.U.d().getId(), this.U.d().getName());
                ai5Var.h(this.f0.o0());
                ai5Var.j(this.f0.E0());
                UserData userData = new UserData();
                userData.setIsManager(this.f0.s0());
                C0(sparseArray, ai5Var, userData);
            } else {
                G0(sparseArray);
            }
        }
    }

    public void i0(SparseArray<Object> sparseArray, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048624, this, sparseArray, z) == null) {
            boolean z2 = true;
            if (this.J == null) {
                Dialog dialog = new Dialog(this.f.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f10039f);
                this.J = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.J.setCancelable(true);
                this.E = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02bf, (ViewGroup) null);
                this.f.getLayoutMode().j(this.E);
                this.J.setContentView(this.E);
                WindowManager.LayoutParams attributes = this.J.getWindow().getAttributes();
                attributes.width = (int) (oi.k(this.f.getPageContext().getPageActivity()) * 0.9d);
                this.J.getWindow().setAttributes(attributes);
            }
            TextView textView = (TextView) this.J.findViewById(R.id.obfuscated_res_0x7f090774);
            TextView textView2 = (TextView) this.J.findViewById(R.id.obfuscated_res_0x7f090a18);
            TextView textView3 = (TextView) this.J.findViewById(R.id.obfuscated_res_0x7f0907c9);
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091e52) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e52)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e58)) && intValue != 2) {
                SparseArray sparseArray2 = (SparseArray) textView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    textView.setTag(sparseArray2);
                }
                textView.setVisibility(0);
                sparseArray2.put(R.id.obfuscated_res_0x7f091e58, sparseArray.get(R.id.obfuscated_res_0x7f091e58));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e5a, sparseArray.get(R.id.obfuscated_res_0x7f091e5a));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e59, sparseArray.get(R.id.obfuscated_res_0x7f091e59));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                textView.setOnClickListener(new i(this));
            } else {
                textView.setVisibility(8);
            }
            if ("".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e63)) && "".equals(sparseArray.get(R.id.obfuscated_res_0x7f091e64))) {
                textView2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) textView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    textView2.setTag(sparseArray3);
                }
                textView2.setVisibility(0);
                sparseArray3.put(R.id.obfuscated_res_0x7f091e63, sparseArray.get(R.id.obfuscated_res_0x7f091e63));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e64, sparseArray.get(R.id.obfuscated_res_0x7f091e64));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e65, sparseArray.get(R.id.obfuscated_res_0x7f091e65));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e75, sparseArray.get(R.id.obfuscated_res_0x7f091e75));
                sparseArray3.put(R.id.obfuscated_res_0x7f091e66, sparseArray.get(R.id.obfuscated_res_0x7f091e66));
                textView2.setOnClickListener(new j(this));
            }
            if (!(((sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue()) ? false : false)) {
                textView3.setVisibility(8);
            } else {
                SparseArray sparseArray4 = (SparseArray) textView3.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    textView3.setTag(sparseArray4);
                }
                textView3.setVisibility(0);
                if (z) {
                    textView3.setText(R.string.obfuscated_res_0x7f0f1467);
                } else {
                    textView3.setText(R.string.obfuscated_res_0x7f0f0b14);
                }
                sparseArray4.put(R.id.obfuscated_res_0x7f091e6d, sparseArray.get(R.id.obfuscated_res_0x7f091e6d));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea7, sparseArray.get(R.id.obfuscated_res_0x7f091ea7));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea8, sparseArray.get(R.id.obfuscated_res_0x7f091ea8));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea9, sparseArray.get(R.id.obfuscated_res_0x7f091ea9));
                sparseArray4.put(R.id.obfuscated_res_0x7f091eaa, sparseArray.get(R.id.obfuscated_res_0x7f091eaa));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ea6, sparseArray.get(R.id.obfuscated_res_0x7f091ea6));
                textView3.setOnClickListener(new k(this, z));
            }
            rg.j(this.J, this.f.getPageContext());
        }
    }

    public void j0(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        i0(sparseArray, false);
    }

    public final void k0(int i2) {
        ArrayList<PostData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048626, this, i2) == null) || (arrayList = this.T) == null) {
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

    public void l0(NewSubPbActivity.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, r0Var) == null) {
            this.Q = r0Var;
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.d.setVisibility(0);
            this.O.setVisibility(8);
            this.B.f();
        }
    }

    public void n0(NewSubPbActivity.r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, r0Var) == null) {
            this.P = r0Var;
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.h0 = z;
        }
    }

    public void p0(cu4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, gVar) == null) {
            this.m0 = gVar;
            o08 o08Var = this.e;
            if (o08Var != null) {
                o08Var.f(gVar);
            }
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.d.setVisibility(0);
            this.O.setVisibility(8);
            this.B.R();
        }
    }

    public void r(boolean z) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048633, this, z) == null) || (subPbModel = this.f0) == null || !subPbModel.K0() || z) {
            return;
        }
        this.k.setIsClose(true);
        this.k.setIsCorner(true);
        this.k.isShowBottomLine(true);
        this.k.setBottomLineHeight(3);
        this.k.setStatusBarVisibility(8);
        this.H = new BlankView(this.f.getPageContext().getPageActivity());
        if (this.f0.L0()) {
            this.g0 = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds562) + UtilHelper.getStatusBarHeight();
        } else {
            this.g0 = oi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070256);
        }
        this.b.addView(this.H, 0, new LinearLayout.LayoutParams(-1, this.g0));
        this.H.setVisibility(0);
        this.H.setOnClickListener(new e(this));
        this.a.setBlankView(this.H);
    }

    public void r0(SubPbModel subPbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, subPbModel) == null) {
            this.f0 = subPbModel;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            w0(this.f);
            this.d.setNextPage(this.B);
        }
    }

    public void s0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, yVar) == null) {
            this.k0.i(yVar);
        }
    }

    public void t(boolean z) {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048637, this, z) == null) || (headImageView = this.a0) == null) {
            return;
        }
        headImageView.K(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
    }

    public void t0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, onLongClickListener) == null) {
            this.k0.h(onLongClickListener);
        }
    }

    public void u() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || this.f0 == null) {
            return;
        }
        if ((!J0() && (view2 = this.G) != null && view2.isShown()) || ListUtils.isEmpty(this.T)) {
            this.f0.a1(false);
        } else {
            this.f0.a1(true);
        }
    }

    public void u0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, onClickListener) == null) {
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
    public void v(PostData postData, int i2, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048641, this, postData, i2, sparseArray) == null) || postData == null) {
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
        rs7 rs7Var = this.U;
        if (rs7Var != null && rs7Var.l() != null && this.U.l().getAuthor() != null && postData.s() != null) {
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
                    int i3 = postData.A() == 1 ? 0 : 1;
                    if (z) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e75, Integer.valueOf(i2));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e66, postData.I());
                        if (postData.s() != null) {
                            sparseArray2.put(R.id.obfuscated_res_0x7f091e63, postData.s().getUserName());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091e64, postData.s().getName_show());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091e65, postData.s().getPortrait());
                        }
                        z5 = true;
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e63, "");
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e64, "");
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e65, "");
                        z5 = false;
                    }
                    if (z2) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e75, Integer.valueOf(i2));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e59, Boolean.TRUE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e5a, Integer.valueOf(i3));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e58, postData.I());
                        z5 = true;
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e59, Boolean.FALSE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e5a, 0);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e58, "");
                    }
                    sparseArray2.put(R.id.obfuscated_res_0x7f091e98, Boolean.valueOf(z5));
                    sparseArray2.put(R.id.obfuscated_res_0x7f091e66, postData.I());
                    if (z) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e98, Boolean.TRUE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e75, Integer.valueOf(i2));
                        if (postData.s() != null) {
                            sparseArray2.put(R.id.obfuscated_res_0x7f091e63, postData.s().getUserName());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091e64, postData.s().getName_show());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091e65, postData.s().getPortrait());
                        }
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e98, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091eab, Boolean.TRUE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e6d, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.s() != null) {
                            sparseArray2.put(R.id.obfuscated_res_0x7f091ea7, postData.s().getUserId());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091ea8, postData.s().getUserName());
                            sparseArray2.put(R.id.obfuscated_res_0x7f091ea6, postData.s().getName_show());
                        }
                        if (this.U.l() != null) {
                            sparseArray2.put(R.id.obfuscated_res_0x7f091eaa, this.U.l().getId());
                        }
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ea9, postData.I());
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091eab, Boolean.FALSE);
                    }
                    if (z2) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e96, Boolean.TRUE);
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e75, Integer.valueOf(i2));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e59, Boolean.valueOf(z4));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e5a, Integer.valueOf(i3));
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e58, postData.I());
                        sparseArray2.put(R.id.obfuscated_res_0x7f091e6a, Boolean.valueOf(postData.d0()));
                        return;
                    }
                    sparseArray2.put(R.id.obfuscated_res_0x7f091e96, Boolean.FALSE);
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
                if (postData.A() == 1) {
                }
                if (z) {
                }
                if (z2) {
                }
                sparseArray2.put(R.id.obfuscated_res_0x7f091e98, Boolean.valueOf(z5));
                sparseArray2.put(R.id.obfuscated_res_0x7f091e66, postData.I());
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
        if (postData.A() == 1) {
        }
        if (z) {
        }
        if (z2) {
        }
        sparseArray2.put(R.id.obfuscated_res_0x7f091e98, Boolean.valueOf(z5));
        sparseArray2.put(R.id.obfuscated_res_0x7f091e66, postData.I());
        if (z) {
        }
        if (z3) {
        }
        if (z2) {
        }
    }

    public void v0(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, onScrollListener) == null) {
            this.d.setOnScrollListener(onScrollListener);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            MorePopupWindow morePopupWindow = this.D;
            if (morePopupWindow != null) {
                rg.d(morePopupWindow, this.f.getPageContext().getPageActivity());
            }
            er4 er4Var = this.F;
            if (er4Var != null) {
                er4Var.e();
            }
            cr4 cr4Var = this.K;
            if (cr4Var != null) {
                cr4Var.dismiss();
            }
            Dialog dialog = this.J;
            if (dialog != null) {
                rg.b(dialog, this.f.getPageContext());
            }
            ProgressBar progressBar = this.O;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            pv7 pv7Var = this.c0;
            if (pv7Var != null) {
                pv7Var.dismiss();
            }
        }
    }

    public void w0(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, pVar) == null) {
            this.d.setOnSrollToBottomListener(pVar);
        }
    }

    public final void x(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048645, this, z) == null) || (bdTypeListView = this.d) == null) {
            return;
        }
        if (!z) {
            bdTypeListView.setEnabled(z);
        } else {
            bdTypeListView.postDelayed(new a(this, z), 10L);
        }
    }

    public void x0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, view2) == null) {
            this.C = view2;
        }
    }

    public void y(rs7 rs7Var, PostData postData, boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{rs7Var, postData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) || postData == null || this.h0) {
            return;
        }
        if (!StringUtils.isNull(postData.z())) {
            this.w.setVisibility(0);
            this.w.K(postData.z(), 10, true);
        } else {
            this.w.setVisibility(8);
        }
        wk8 v = postData.v();
        if (v != null && v.a) {
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
        sparseArray.put(R.id.obfuscated_res_0x7f091e56, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091e6f, Boolean.FALSE);
        v(postData, i2, sparseArray);
        this.q.setText((CharSequence) null);
        this.t.setVisibility(8);
        if (!this.h0) {
            K0(postData.s());
            if (z) {
                this.t.setVisibility(0);
                SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0302);
            }
        }
        this.u.setText(StringHelper.getFormatTime(postData.X()));
        postData.s().getUserTbVipInfoData();
        boolean z0 = z0(this.v, postData.P());
        if (StringUtils.isNull(postData.z()) && !z0 && postData.b0() != null) {
            this.x.setVisibility(0);
            this.x.setTag(postData.b0());
            return;
        }
        this.x.setVisibility(8);
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            this.O.setVisibility(0);
        }
    }

    public void z(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048649, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            ProgressBar progressBar = this.O;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (z && z2) {
                NewSubPbActivity newSubPbActivity = this.f;
                newSubPbActivity.showToast(newSubPbActivity.getResources().getString(R.string.obfuscated_res_0x7f0f04a3));
            } else if (str == null || !z2) {
            } else {
                this.f.showToast(str);
            }
        }
    }

    public final boolean z0(TextView textView, TbRichText tbRichText) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048650, this, textView, tbRichText)) == null) {
            if (textView != null && tbRichText != null && tbRichText.A() != null) {
                TbRichTextData tbRichTextData = new TbRichTextData(1);
                Iterator<TbRichTextData> it = tbRichText.A().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        int type = next.getType();
                        if (type != 1) {
                            if (type != 2) {
                                if (type == 17) {
                                    String str = next.B().mGifInfo.mSharpText;
                                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                                        String substring = str.substring(2, str.length() - 1);
                                        tbRichTextData.z(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                                    }
                                } else if (type != 18 && type != 1282) {
                                }
                            }
                            tbRichTextData.T(true);
                            textView.setMovementMethod(rw8.a());
                        } else {
                            tbRichTextData.z(next.I());
                        }
                    }
                }
                if (!tbRichTextData.P()) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                try {
                    if (tbRichTextData.I() == null || tbRichTextData.I().length() <= 0) {
                        return false;
                    }
                    textView.setText(tbRichTextData.I());
                    return true;
                } catch (Exception unused) {
                    textView.setText("");
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
