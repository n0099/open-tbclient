package com.repackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.ShareFriendActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.baidu.tieba.transmitShare.ShareScrollableLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nr4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
/* loaded from: classes5.dex */
public class ee8 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int L;
    public static final int M;
    public static int N;
    public static int O;
    public static int P;
    public static int Q;
    public transient /* synthetic */ FieldHolder $fh;
    public ShareItem A;
    public final SparseArray<ShareItem> B;
    public boolean C;
    public SparseArray<String> D;
    public SparseArray<by4> E;
    public boolean F;
    public int G;
    public boolean H;
    public boolean I;
    public CustomMessageListener J;
    public int K;
    public final Context a;
    public final View b;
    public final View c;
    public final TextView d;
    public ShareScrollableLayout e;
    public ShareGridLayout f;
    public final EMTextView g;
    public final List<View> h;
    public View.OnClickListener i;
    public DialogInterface.OnDismissListener j;
    public DialogInterface.OnCancelListener k;
    public AlertDialog l;
    public float m;
    public PermissionJudgePolicy n;
    public RelativeLayout o;
    public ImageView p;
    public TextView q;
    public MessageRedDotView r;
    public ImageView s;
    public boolean t;
    public String u;
    public ArrayList<MetaData> v;
    public ArrayList<MetaData> w;
    public ArrayList<MetaData> x;
    public ArrayList<MetaData> y;
    public ArrayList<String> z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ee8 ee8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee8Var, Integer.valueOf(i)};
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
            this.a = ee8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.u();
                if (this.a.e != null) {
                    this.a.e.removeAllViews();
                } else {
                    this.a.f.removeAllViews();
                }
                if (this.a.e != null) {
                    this.a.t();
                } else {
                    this.a.s();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee8 a;

        public b(ee8 ee8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee8Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.a.l == null || !this.a.l.isShowing()) {
                    return null;
                }
                this.a.w();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee8 a;

        public c(ee8 ee8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee8Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.j != null) {
                    this.a.j.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001277);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
                if (!this.a.D(1).m || this.a.I) {
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921696, 3));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee8 a;

        public d(ee8 ee8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee8Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.a.k == null) {
                return;
            }
            this.a.k.onCancel(dialogInterface);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ ee8 b;

        public e(ee8 ee8Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee8Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ee8Var;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.l != null) {
                    this.b.l.dismiss();
                }
                this.a.onClick(view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends InsertGalleryAsyncTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ee8 a;

        public f(ee8 ee8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ee8Var;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                mi.N(this.a.a, "保存失败！");
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                mi.N(this.a.a, "保存成功！");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ ee8 b;

        public g(ee8 ee8Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee8Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ee8Var;
            this.a = shareItem;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                bi.a(this.a.u);
                mi.M(this.b.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f0448);
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(ee8 ee8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee8Var};
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

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;
        public final /* synthetic */ ee8 b;

        public i(ee8 ee8Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ee8Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ee8Var;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.w();
                View.OnClickListener onClickListener = this.a;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755740391, "Lcom/repackage/ee8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755740391, "Lcom/repackage/ee8;");
                return;
            }
        }
        L = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        M = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds239);
        N = 10;
        O = 8;
        P = 1;
        Q = 2;
    }

    @SuppressLint({"ResourceType"})
    public ee8(Context context, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = 0.33f;
        this.x = new ArrayList<>();
        this.y = new ArrayList<>();
        this.z = new ArrayList<>();
        this.B = new SparseArray<>(8);
        this.C = false;
        this.F = true;
        this.G = 1;
        this.H = true;
        this.J = new a(this, 2001304);
        this.K = 0;
        this.K = i2;
        this.a = context;
        this.h = new ArrayList();
        View B = B();
        this.b = B;
        this.c = B.findViewById(R.id.obfuscated_res_0x7f091cf5);
        this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091cf6);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.d.setText(sharePanelText);
        }
        ShareScrollableLayout shareScrollableLayout = (ShareScrollableLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091d13);
        this.e = shareScrollableLayout;
        if (shareScrollableLayout == null) {
            ShareGridLayout shareGridLayout = (ShareGridLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091cfa);
            this.f = shareGridLayout;
            ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i5 = ShareGridLayout.f;
                marginLayoutParams.leftMargin = i5;
                marginLayoutParams.rightMargin = i5;
                this.f.setLayoutParams(marginLayoutParams);
            }
            this.f.setItemParams(L, M);
        } else {
            shareScrollableLayout.setItemParams(L, M);
        }
        EMTextView eMTextView = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090402);
        this.g = eMTextView;
        eMTextView.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090b9a);
        this.o = relativeLayout;
        if (relativeLayout != null) {
            this.p = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09185b);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09185a);
            this.q = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f0e58);
            MessageRedDotView messageRedDotView = (MessageRedDotView) this.b.findViewById(R.id.obfuscated_res_0x7f09185d);
            this.r = messageRedDotView;
            messageRedDotView.setExtendSize(mi.f(context, R.dimen.tbds5));
            this.r.setTextSize(R.dimen.T_X09);
            this.r.setTextBold(true);
            this.s = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09185c);
        }
    }

    public final String A(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, shareItem)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(shareItem.t)) {
                sb.append("【");
                sb.append(shareItem.t);
                sb.append("】 ");
            }
            if (!TextUtils.isEmpty(shareItem.t)) {
                sb.append(shareItem.u);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0213, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final Location C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? pz5.b() : (Location) invokeV.objValue;
    }

    public ShareItem D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            ShareItem shareItem = this.B.get(i2);
            return shareItem == null ? this.B.get(1) : shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.v = u87.a();
            this.w = w87.a();
            y();
            ArrayList<MetaData> arrayList = this.v;
            if (arrayList != null && this.w != null && arrayList.size() != 0 && this.w.size() != 0) {
                this.x.addAll(this.v);
                this.x.addAll(this.w);
            } else {
                ArrayList<MetaData> arrayList2 = this.v;
                if (arrayList2 != null && arrayList2.size() != 0) {
                    this.x.addAll(this.v);
                } else {
                    ArrayList<MetaData> arrayList3 = this.w;
                    if (arrayList3 != null && arrayList3.size() != 0) {
                        this.x.addAll(this.w);
                    }
                }
            }
            Y();
        }
    }

    public void F(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, onDismissListener) == null) || onDismissListener == null) {
            return;
        }
        this.j = onDismissListener;
    }

    public LinearLayout G(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i2, i3)) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.a();
            return shareDialogItemView;
        }
        return (LinearLayout) invokeII.objValue;
    }

    public final boolean H(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, shareItem)) == null) ? (TextUtils.isEmpty(shareItem.x0) || TextUtils.isEmpty(shareItem.y0)) ? false : true : invokeL.booleanValue;
    }

    public final boolean I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? (i2 & 8) > 0 : invokeI.booleanValue;
    }

    public final boolean J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? (i2 & 4) > 0 : invokeI.booleanValue;
    }

    public final boolean K(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? (i2 & 1) > 0 : invokeI.booleanValue;
    }

    public final boolean L(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? (i2 & 2) > 0 : invokeI.booleanValue;
    }

    public final boolean M(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? (i2 & 16) > 0 : invokeI.booleanValue;
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.o != null : invokeV.booleanValue;
    }

    public final boolean O(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? (i2 & 32) > 0 : invokeI.booleanValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921694, this.A.e0);
            MessageManager.getInstance().registerStickyMode(2921694);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            ShareFriendActivityConfig shareFriendActivityConfig = new ShareFriendActivityConfig(this.a);
            shareFriendActivityConfig.setIsForShare(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, shareFriendActivityConfig));
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SHARE_FRIEND_BTN);
            int i2 = this.A.G;
            int i3 = 2;
            if (i2 == 4 || i2 == 3 || i2 == 20 || i2 == 30) {
                i3 = 1;
            } else if (i2 != 5 && i2 != 10 && i2 != 33) {
                i3 = (i2 == 6 || i2 == 2) ? 3 : i2 == 8 ? 4 : (i2 == 25 || i2 == 29 || i2 == 11 || i2 == 12) ? 5 : 0;
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", i3);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_SHARE_NEARLY_PERSON);
            int i2 = this.A.G;
            int i3 = 2;
            if (i2 == 4 || i2 == 3 || i2 == 20 || i2 == 30) {
                i3 = 1;
            } else if (i2 != 5 && i2 != 10 && i2 != 33) {
                i3 = (i2 == 6 || i2 == 2) ? 3 : i2 == 8 ? 4 : (i2 == 25 || i2 == 29 || i2 == 11 || i2 == 12) ? 5 : 0;
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_source", i3);
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, str);
            TiebaStatic.log(statisticItem);
        }
    }

    public void S(ShareDialogConfig.From from) {
        ay4 sharePanelConfData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, from) == null) && (sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData()) != null && sharePanelConfData.d(from) && sharePanelConfData.c() && !li.isEmpty(sharePanelConfData.b())) {
            this.d.setText(sharePanelConfData.b());
        }
    }

    public void T(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && N()) {
            if (z) {
                if (i2 <= 0) {
                    this.r.setVisibility(8);
                } else {
                    this.r.setVisibility(0);
                    this.r.f(i2);
                }
                this.r.setVisibility(0);
                return;
            }
            this.r.setVisibility(8);
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new b(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.i = onClickListener;
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
        }
    }

    public void X(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.u = str;
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            for (int i2 = 0; i2 < this.x.size(); i2++) {
                if (this.x.get(i2).getUserId() == null) {
                    this.y.add(this.x.get(i2));
                } else if (!this.z.contains(this.x.get(i2).getUserId())) {
                    this.z.add(this.x.get(i2).getUserId());
                    this.y.add(this.x.get(i2));
                }
            }
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.F = z;
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.t = z;
        }
    }

    public void b0(SparseArray<String> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, sparseArray) == null) {
            this.D = sparseArray;
        }
    }

    public void c0(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onCancelListener) == null) {
            this.k = onCancelListener;
        }
    }

    public void d0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) && N()) {
            this.o.setOnClickListener(new e(this, onClickListener));
        }
    }

    public void e0(ShareItem shareItem, boolean z) {
        Location C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048606, this, shareItem, z) == null) {
            this.A = shareItem;
            if (z && (C = C()) != null) {
                shareItem.D = C;
            }
            this.B.put(1, shareItem);
            if (StringUtils.isNull(shareItem.p)) {
                return;
            }
            this.d.setText(shareItem.p);
        }
    }

    public void f0(int i2, ShareItem shareItem, boolean z) {
        Location C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), shareItem, Boolean.valueOf(z)}) == null) {
            if (z && (C = C()) != null) {
                shareItem.D = C;
            }
            this.B.put(i2, shareItem);
        }
    }

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.G = i2;
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            E();
            ShareItem shareItem = this.A;
            boolean z = shareItem.g || shareItem.i || shareItem.m || shareItem.r0;
            ArrayList<MetaData> arrayList = this.y;
            if (arrayList != null && arrayList.size() != 0 && !M(this.K) && TbadkCoreApplication.getCurrentAccount() != null && !z) {
                o0(0, 1, 2);
            } else if (z) {
                this.e.setItemParams(mi.k(this.a) / 5, M);
                p0(0, 1, z);
            } else {
                n0(0, 1);
            }
        }
    }

    public void i(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048610, this, i2, i3) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            List<View> list = this.h;
            shareDialogItemView.a();
            list.add(shareDialogItemView);
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.H = z;
        }
    }

    public final void j(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048612, this, i2, i3, i4, i5) == null) {
            q(i2, i3, SkinManager.getColor(R.color.CAM_X0107), i4, i5);
        }
    }

    public void j0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, window) == null) {
            window.setLayout(-1, -2);
        }
    }

    public final void k(int i2, int i3, int i4, boolean z, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Integer.valueOf(i5)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, 0, i4);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.a();
            MaskView.c(shareDialogItemView, z);
            this.e.b(i5, shareDialogItemView);
        }
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.G == 2 && v() : invokeV.booleanValue;
    }

    public void l(int i2, AbsSvgType absSvgType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048616, this, i2, absSvgType) == null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
        shareDialogItemView.setItemIcon(absSvgType);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        List<View> list = this.h;
        shareDialogItemView.a();
        list.add(shareDialogItemView);
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.I = false;
            if (!ki.z()) {
                mi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1140);
            } else if (!fz4.n()) {
                mi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0e95);
            } else {
                if (this.e != null) {
                    t();
                } else {
                    r();
                }
                AlertDialog create = new AlertDialog.Builder(this.a, R.style.obfuscated_res_0x7f100104).create();
                this.l = create;
                create.setCanceledOnTouchOutside(true);
                this.l.setOnDismissListener(new c(this));
                this.l.setOnCancelListener(new d(this));
                Context context = this.a;
                if (context instanceof Activity) {
                    pg.i(this.l, (Activity) context);
                }
                gs4 d2 = gs4.d(this.c);
                d2.n(R.string.J_X14);
                d2.f(R.color.CAM_X0204);
                Window window = this.l.getWindow();
                if (window == null) {
                    return;
                }
                if (this.H) {
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = mi.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ee);
                } else {
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f1003c3);
                }
                window.setGravity(80);
                j0(window);
                window.setContentView(this.b);
                window.setDimAmount(this.m);
                u();
                x();
                U();
                f9.a(this.a).registerListener(this.J);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
            }
        }
    }

    public void m(View view2, int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048618, this, view2, i2, onClickListener) == null) || i2 > this.h.size() || i2 < 0) {
            return;
        }
        this.h.add(i2, view2);
        if (onClickListener != null) {
            view2.setOnClickListener(new i(this, onClickListener));
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            if (!K(this.K)) {
                l(R.string.obfuscated_res_0x7f0f116b, new SvgMaskType(R.drawable.obfuscated_res_0x7f080816));
            }
            if (!L(this.K)) {
                l(R.string.obfuscated_res_0x7f0f1172, new SvgMaskType(R.drawable.obfuscated_res_0x7f080812));
            }
            if (!I(this.K)) {
                l(R.string.obfuscated_res_0x7f0f114a, new SvgMaskType(R.drawable.obfuscated_res_0x7f080813));
            }
            if (!J(this.K)) {
                l(R.string.obfuscated_res_0x7f0f114e, new SvgMaskType(R.drawable.obfuscated_res_0x7f080814));
            }
            if (!M(this.K)) {
                l(R.string.obfuscated_res_0x7f0f1159, new SvgMaskType(R.drawable.obfuscated_res_0x7f080817));
            }
            if (O(this.K)) {
                i(R.string.obfuscated_res_0x7f0f1152, R.drawable.obfuscated_res_0x7f0809a7);
            }
            if (arrayList.size() > 0) {
                this.h.addAll(arrayList);
            }
            if (this.F) {
                i(R.string.obfuscated_res_0x7f0f1132, R.drawable.obfuscated_res_0x7f0809a4);
            }
        }
    }

    public final void n(@NonNull MetaData metaData, int i2, boolean z, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{metaData, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(metaData.getAvater(), i2, metaData);
            String name_show = metaData.getName_show();
            if (xd5.d(metaData.getName_show()) > O) {
                name_show = xd5.n(name_show, O) + StringHelper.STRING_MORE;
            }
            shareDialogItemView.setItemName(name_show);
            shareDialogItemView.setOnClickListener(this);
            shareDialogItemView.setTag(R.id.obfuscated_res_0x7f090947, metaData);
            shareDialogItemView.a();
            MaskView.c(shareDialogItemView, z);
            this.e.b(i3, shareDialogItemView);
        }
    }

    public final void n0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048621, this, i2, i3) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            if (TbadkCoreApplication.getCurrentAccount() != null && !M(this.K)) {
                k(R.string.obfuscated_res_0x7f0f1137, R.drawable.obfuscated_res_0x7f080861, 24, false, i2);
            }
            if (!K(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080816), R.string.obfuscated_res_0x7f0f116b, i2);
            }
            if (!L(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080812), R.string.obfuscated_res_0x7f0f1172, i2);
            }
            if (!I(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080813), R.string.obfuscated_res_0x7f0f114a, i2);
            }
            if (!J(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080814), R.string.obfuscated_res_0x7f0f114e, i2);
            }
            if (!M(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080817), R.string.obfuscated_res_0x7f0f1159, i2);
            }
            if (O(this.K)) {
                j(R.string.obfuscated_res_0x7f0f1152, R.drawable.obfuscated_res_0x7f0809a7, 17, i3);
            }
            if (arrayList.size() > 0 && arrayList.size() > 0) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    this.e.b(i3, (View) arrayList.get(i4));
                }
            }
            if (this.F) {
                j(R.string.obfuscated_res_0x7f0f1132, R.drawable.obfuscated_res_0x7f0809a4, 27, i3);
            }
        }
    }

    public final void o(AbsSvgType absSvgType, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048622, this, absSvgType, i2, i3) == null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
        shareDialogItemView.setItemIcon(absSvgType);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        ShareScrollableLayout shareScrollableLayout = this.e;
        shareDialogItemView.a();
        shareScrollableLayout.b(i3, shareDialogItemView);
    }

    public final void o0(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048623, this, i2, i3, i4) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            int size = this.y.size();
            if (size < N) {
                for (int i5 = 0; i5 < size; i5++) {
                    n(this.y.get(i5), 25, false, i2);
                }
            } else {
                for (int i6 = 0; i6 < N; i6++) {
                    n(this.y.get(i6), 25, false, i2);
                }
            }
            this.e.a(i2);
            if (size >= N) {
                j(R.string.obfuscated_res_0x7f0f0add, R.drawable.obfuscated_res_0x7f080a3a, 28, i2);
            }
            k(R.string.obfuscated_res_0x7f0f1137, R.drawable.obfuscated_res_0x7f080861, 24, false, i3);
            if (!K(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080816), R.string.obfuscated_res_0x7f0f116b, i3);
            }
            if (!L(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080812), R.string.obfuscated_res_0x7f0f1172, i3);
            }
            if (!I(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080813), R.string.obfuscated_res_0x7f0f114a, i3);
            }
            if (!J(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080814), R.string.obfuscated_res_0x7f0f114e, i3);
            }
            if (!M(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080817), R.string.obfuscated_res_0x7f0f1159, i3);
            }
            if (O(this.K)) {
                j(R.string.obfuscated_res_0x7f0f1152, R.drawable.obfuscated_res_0x7f0809a7, 26, i4);
            }
            if (arrayList.size() > 0) {
                for (int i7 = 0; i7 < arrayList.size(); i7++) {
                    this.e.b(i4, (View) arrayList.get(i7));
                }
            }
            if (this.F) {
                j(R.string.obfuscated_res_0x7f0f1132, R.drawable.obfuscated_res_0x7f0809a4, 27, i4);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, view2) == null) {
            this.I = true;
            int id = view2.getId();
            int intValue = view2.getTag() != null ? ((Integer) view2.getTag()).intValue() : -1;
            if (id != R.id.obfuscated_res_0x7f090402 && intValue != R.drawable.obfuscated_res_0x7f0809a4 && k0()) {
                this.C = false;
                return;
            }
            if (intValue != R.drawable.obfuscated_res_0x7f0809a7) {
                w();
            }
            if (this.B.size() == 0) {
                return;
            }
            if (id == R.id.obfuscated_res_0x7f090402 || !this.C) {
                this.C = true;
                ShareItem D = D(1);
                fz4 fz4Var = new fz4(this.a, null);
                if (D != null && D.r0) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_AI_APP_SHARE_CLICK).param("obj_id", D.s0).param("obj_type", D.t0).param("obj_source", D.u0));
                    Bundle bundle = new Bundle();
                    bundle.putInt("source", 16);
                    D.k(bundle);
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                    statisticItem.param("obj_source", 25);
                    TiebaStatic.log(statisticItem);
                }
                if (id == R.id.obfuscated_res_0x7f090402) {
                    s0("share_cancel", new Object[0]);
                    if (D != null && D.g) {
                        w0(D, 16);
                    }
                    DialogInterface.OnCancelListener onCancelListener = this.k;
                    if (onCancelListener != null) {
                        onCancelListener.onCancel(this.l);
                    }
                    if (D.m) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921696, 3));
                        return;
                    }
                    return;
                }
                if (D != null && D.p0) {
                    StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                    statisticItem2.param("obj_source", 31);
                    TiebaStatic.log(statisticItem2);
                }
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
                statisticItem3.param("obj_param1", this.u);
                if (intValue == R.drawable.obfuscated_res_0x7f080816) {
                    if (!ki.z()) {
                        mi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1140);
                        return;
                    }
                    s0("share_to_weixin", new Object[0]);
                    t0(3);
                    D = D(3);
                    w0(D, 4);
                    if (D != null) {
                        if (H(D) && D.a() != null && D.a().contains(3)) {
                            zy4.e(D, this.a, 3, this.k);
                        } else if (D.n0 == 1) {
                            q0(D);
                        } else {
                            fz4Var.t(D);
                        }
                    }
                    statisticItem3.param("obj_type", 2);
                } else if (intValue == R.drawable.obfuscated_res_0x7f080812) {
                    if (!ki.z()) {
                        mi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1140);
                        return;
                    }
                    s0("share_to_pyq", new Object[0]);
                    t0(2);
                    D = D(2);
                    w0(D, 3);
                    if (D != null) {
                        if (H(D) && D.a() != null && D.a().contains(2)) {
                            zy4.e(D, this.a, 2, this.k);
                        } else if (D.n0 == 1) {
                            q0(D);
                        } else {
                            if (D.b) {
                                D.u = "【" + D.t + "】 " + D.u;
                            }
                            fz4Var.u(D);
                        }
                    }
                    statisticItem3.param("obj_type", 3);
                } else if (intValue == R.drawable.obfuscated_res_0x7f080814) {
                    if (!ki.z()) {
                        mi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1140);
                        return;
                    }
                    if (dj8.b(this.a, "com.tencent.mobileqq")) {
                        s0("share_to_qzone", new Object[0]);
                        t0(4);
                        D = D(4);
                        w0(D, 5);
                        if (D != null) {
                            if (H(D) && D.a() != null && D.a().contains(4)) {
                                zy4.e(D, this.a, 4, this.k);
                            } else {
                                fz4Var.p(D);
                            }
                        }
                    } else {
                        Context context = this.a;
                        BdToast.c(context, context.getText(R.string.obfuscated_res_0x7f0f114b)).q();
                    }
                    statisticItem3.param("obj_type", 5);
                } else if (intValue == R.drawable.icon_qq_weibo) {
                    if (!ki.z()) {
                        mi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1140);
                        return;
                    }
                    s0("share_to_qweibo", new Object[0]);
                    t0(5);
                    D = D(5);
                    if (D != null) {
                        if (!D.a) {
                            D.u = A(D);
                        }
                        fz4Var.s(D);
                    }
                } else if (intValue == R.drawable.obfuscated_res_0x7f080817) {
                    if (!ki.z()) {
                        mi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1140);
                        return;
                    }
                    s0("share_to_sweibo", new Object[0]);
                    t0(6);
                    D = D(6);
                    w0(D, 7);
                    if (D != null) {
                        if (!D.a) {
                            D.u = A(D);
                        }
                        if (H(D) && D.a() != null && D.a().contains(4)) {
                            zy4.e(D, this.a, 6, this.k);
                        } else {
                            fz4Var.r(D);
                        }
                    }
                    statisticItem3.param("obj_type", 6);
                } else if (intValue == R.drawable.icon_renren) {
                    if (!ki.z()) {
                        mi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1140);
                        return;
                    }
                    s0("share_to_renren", new Object[0]);
                    t0(7);
                    D = D(7);
                    if (D != null) {
                        if (!D.a) {
                            D.u = A(D);
                        }
                        fz4Var.q(D);
                    }
                } else if (intValue == R.drawable.obfuscated_res_0x7f080813) {
                    if (!ki.z()) {
                        mi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1140);
                        return;
                    }
                    if (dj8.b(this.a, "com.tencent.mobileqq")) {
                        s0("share_to_qq_friend", new Object[0]);
                        t0(8);
                        D = D(8);
                        w0(D, 9);
                        if (D != null) {
                            if (H(D) && D.a() != null && D.a().contains(4)) {
                                zy4.e(D, this.a, 8, this.k);
                            } else {
                                fz4Var.o(D);
                            }
                        }
                    } else {
                        Context context2 = this.a;
                        BdToast.c(context2, context2.getText(R.string.obfuscated_res_0x7f0f114b)).q();
                    }
                    statisticItem3.param("obj_type", 4);
                } else if (intValue == R.drawable.obfuscated_res_0x7f0809a7) {
                    if (this.n == null) {
                        this.n = new PermissionJudgePolicy();
                    }
                    this.n.clearRequestPermissionList();
                    this.n.appendRequestPermission((Activity) this.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.n.startRequestPermission((Activity) this.a)) {
                        this.C = false;
                        return;
                    }
                    w();
                    w0(D, 17);
                    if (FileHelper.isLocalFile(D.x)) {
                        if (FileHelper.copyImageFile(FileHelper.getImageRealPathFromUri(this.a, D.x), UUID.randomUUID().toString().replace("-", "").toLowerCase(), this.a) == 0) {
                            mi.N(this.a, "保存成功！");
                        } else {
                            mi.N(this.a, "保存失败！");
                        }
                    } else {
                        Uri uri = D.x;
                        if (uri == null) {
                            return;
                        }
                        String uri2 = uri.toString();
                        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                        if (currentActivity == null) {
                            return;
                        }
                        new InsertGalleryAsyncTask(currentActivity, uri2, new f(this)).execute(new String[0]);
                    }
                    statisticItem3.param("obj_type", 1);
                } else if (intValue == R.drawable.obfuscated_res_0x7f0809a4) {
                    w0(D, 10);
                    View.OnClickListener onClickListener = this.i;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                    } else {
                        bi.a(D.v);
                        mi.N(this.a.getApplicationContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0447));
                    }
                    u0(D);
                    if (D != null && D.a) {
                        v0(8, D.E);
                    }
                    statisticItem3.param("obj_type", 8);
                } else if (intValue == 25) {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090947);
                    if (this.a != null && (shareItem = this.A) != null && shareItem.e0 != null && (tag instanceof MetaData)) {
                        MetaData metaData = (MetaData) tag;
                        R(metaData.getUserId());
                        a87 a87Var = new a87(this.a);
                        a87Var.n(this.A.e0, metaData);
                        a87Var.p();
                    }
                } else if (intValue == 24) {
                    P();
                    Q();
                } else if (intValue == 28) {
                    P();
                }
                statisticItem3.param("obj_source", 6);
                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (D != null) {
                    statisticItem3.param("fid", D.s);
                    statisticItem3.param("fname", D.r);
                }
                TiebaStatic.log(statisticItem3);
            }
        }
    }

    public final void p0(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            ArrayList arrayList = new ArrayList(this.h);
            this.h.clear();
            if (TbadkCoreApplication.getCurrentAccount() != null && !z) {
                k(R.string.obfuscated_res_0x7f0f1137, R.drawable.obfuscated_res_0x7f080861, 24, false, i2);
            }
            if (!K(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080816), R.string.obfuscated_res_0x7f0f116b, i2);
            }
            if (!L(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080812), R.string.obfuscated_res_0x7f0f1172, i2);
            }
            if (!I(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080813), R.string.obfuscated_res_0x7f0f114a, i2);
            }
            if (!J(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080814), R.string.obfuscated_res_0x7f0f114e, i2);
            }
            if (!M(this.K)) {
                o(new SvgMaskType(R.drawable.obfuscated_res_0x7f080817), R.string.obfuscated_res_0x7f0f1159, i2);
            }
            if (O(this.K)) {
                j(R.string.obfuscated_res_0x7f0f1152, R.drawable.obfuscated_res_0x7f0809a7, 17, i3);
            }
            if (arrayList.size() > 0 && arrayList.size() > 0) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    this.e.b(i3, (View) arrayList.get(i4));
                }
            }
            if (this.F) {
                i(R.string.obfuscated_res_0x7f0f1132, R.drawable.obfuscated_res_0x7f0809a4);
            }
        }
    }

    public final void q(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, i4, i5);
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            ShareScrollableLayout shareScrollableLayout = this.e;
            shareDialogItemView.a();
            shareScrollableLayout.b(i6, shareDialogItemView);
        }
    }

    public final void q0(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, shareItem) == null) || shareItem == null || TextUtils.isEmpty(shareItem.u) || TextUtils.isEmpty(shareItem.t)) {
            return;
        }
        Context context = this.a;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            nr4 nr4Var = new nr4(activity);
            nr4Var.setTitle(shareItem.t);
            nr4Var.setMessage(shareItem.u);
            nr4Var.setAutoNight(false);
            nr4Var.setCancelable(true);
            nr4Var.setTitleShowCenter(true);
            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1132, new g(this, shareItem));
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f112d, new h(this)).create(f9.a(activity));
            nr4Var.show();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || r0()) {
            return;
        }
        m0();
        if (!fz4.n()) {
            this.f.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.f.addView(this.h.get(i2), new ViewGroup.LayoutParams(L, M));
        }
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || r0()) {
            return;
        }
        m0();
        if (!fz4.n()) {
            this.f.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.f.addView(this.h.get(i2), new ViewGroup.LayoutParams(L, M));
        }
    }

    public final void s0(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048631, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.a, str, "click", 1, objArr);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || r0()) {
            return;
        }
        h0();
        if (!fz4.n()) {
            this.e.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.e.addView(this.h.get(i2), new ViewGroup.LayoutParams(L, M));
        }
    }

    public final void t0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048633, this, i2) == null) || i2 > 8 || i2 <= 0) {
            return;
        }
        this.C = true;
        SparseArray<by4> sparseArray = this.E;
        if (sparseArray != null) {
            by4 by4Var = sparseArray.get(i2);
            if (!StringUtils.isNull(by4Var.b()) && by4Var.a() != null && by4Var.a().size() > 0) {
                s0(by4Var.b(), by4Var.a());
                return;
            }
        }
        SparseArray<String> sparseArray2 = this.D;
        if (sparseArray2 != null) {
            String str = sparseArray2.get(i2);
            if (li.isEmpty(str)) {
                return;
            }
            s0(str, new Object[0]);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            gs4 d2 = gs4.d(this.c);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColorSelector(this.g, R.color.CAM_X0107);
            if (N()) {
                gs4 d3 = gs4.d(this.o);
                d3.n(R.string.J_X05);
                d3.f(R.color.CAM_X0201);
                this.p.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809d9, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
                gs4 d4 = gs4.d(this.q);
                d4.A(R.string.F_X01);
                d4.v(R.color.CAM_X0105);
            }
        }
    }

    public final void u0(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
            int i2 = shareItem.H;
            if (i2 != 0) {
                param.param("obj_param1", i2);
                int i3 = shareItem.H;
                if (i3 == 2) {
                    param.param("fid", shareItem.L);
                } else if (i3 == 3) {
                    int i4 = shareItem.O;
                    if (i4 != 0) {
                        param.param("obj_type", i4);
                    }
                    param.param("tid", shareItem.M).param("fid", shareItem.L);
                }
            }
            param.param("obj_locate", 9);
            TiebaStatic.log(param);
        }
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (this.a instanceof Activity) {
                if (this.n == null) {
                    this.n = new PermissionJudgePolicy();
                }
                this.n.clearRequestPermissionList();
                this.n.appendRequestPermission((Activity) this.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                return this.n.startRequestPermission((Activity) this.a);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void v0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048637, this, i2, str) == null) {
            TiebaStatic.eventStat(this.a, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public void w() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || (alertDialog = this.l) == null) {
            return;
        }
        this.C = false;
        if (this.a instanceof Activity) {
            DialogInterface.OnDismissListener onDismissListener = this.j;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(alertDialog);
            }
            pg.a(this.l, (Activity) this.a);
            MessageManager.getInstance().unRegisterListener(this.J);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    public final void w0(ShareItem shareItem, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048639, this, shareItem, i2) == null) || shareItem == null) {
            return;
        }
        if (shareItem.s == null) {
            if (shareItem.j) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2).param("obj_source", shareItem.G));
            }
        } else if (shareItem.b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.s).param("obj_type", i2).param("obj_source", shareItem.G).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.I));
        } else if (!shareItem.c && !shareItem.f) {
            if (shareItem.d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.s).param("obj_type", i2));
            } else if (shareItem.a) {
                v0(i2, shareItem.E);
            } else if (shareItem.e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.s).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.I));
            } else if (shareItem.g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                param.param("obj_source", shareItem.G);
                if (!li.isEmpty(shareItem.v)) {
                    if (shareItem.v.contains("worldcup")) {
                        param.param("obj_param1", 9);
                    }
                    param.param(TiebaStatic.Params.OBJ_URL, shareItem.v);
                }
                TiebaStatic.log(param);
            } else if (shareItem.i) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_TOPIC_DETAIL).param("obj_locate", i2 == 3 ? "1" : i2 == 4 ? "2" : i2 == 9 ? "4" : i2 == 5 ? "3" : i2 == 7 ? "5" : "6").param("topic_id", shareItem.s));
            } else if (shareItem.k) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem.param("tid", shareItem.s);
                statisticItem.param("post_id", shareItem.a0);
                statisticItem.param("obj_source", 18);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, shareItem.I);
                TiebaStatic.log(statisticItem);
            } else if (shareItem.l) {
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_GAME_DETIAL);
                statisticItem2.param("obj_type", i2);
                statisticItem2.param("obj_name", shareItem.t);
                TiebaStatic.log(statisticItem2);
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem3.param("obj_source", 19);
                TiebaStatic.log(statisticItem3);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.s).param("obj_type", i2).param("obj_source", shareItem.G).param("obj_param1", shareItem.H).param("fid", shareItem.L).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.I));
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            if (this.t) {
                this.d.setVisibility(8);
                if (N()) {
                    this.o.setVisibility(0);
                    return;
                }
                return;
            }
            this.d.setVisibility(0);
            if (N()) {
                this.o.setVisibility(8);
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            ArrayList<MetaData> arrayList = this.v;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<MetaData> it = this.v.iterator();
                while (it.hasNext()) {
                    it.next().setItemType(P);
                }
            }
            ArrayList<MetaData> arrayList2 = this.w;
            if (arrayList2 == null || arrayList2.size() == 0) {
                return;
            }
            Iterator<MetaData> it2 = this.w.iterator();
            while (it2.hasNext()) {
                it2.next().setItemType(Q);
            }
        }
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            List<View> list = this.h;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ee8(Context context) {
        this(context, false, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
