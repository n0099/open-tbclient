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
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.tieba.transmitShare.ShareGridLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dr4;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes6.dex */
public class if8 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int D;
    public static final int E;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;
    public int C;
    public final Context a;
    public final View b;
    public final View c;
    public final TextView d;
    public ShareGridLayout e;
    public final EMTextView f;
    public final List<View> g;
    public View.OnClickListener h;
    public DialogInterface.OnDismissListener i;
    public DialogInterface.OnCancelListener j;
    public AlertDialog k;
    public float l;
    public PermissionJudgePolicy m;
    public RelativeLayout n;
    public ImageView o;
    public TextView p;
    public MessageRedDotView q;
    public ImageView r;
    public boolean s;
    public String t;
    public final SparseArray<ShareItem> u;
    public boolean v;
    public SparseArray<String> w;
    public SparseArray<ox4> x;
    public boolean y;
    public int z;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(if8 if8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if8Var, Integer.valueOf(i)};
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
            this.a = if8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.k();
                this.a.e.removeAllViews();
                this.a.j();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements CustomMessageTask.CustomRunnable<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if8 a;

        public b(if8 if8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if8Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.a.k == null || !this.a.k.isShowing()) {
                    return null;
                }
                this.a.m();
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if8 a;

        public c(if8 if8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if8Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.i != null) {
                    this.a.i.onDismiss(dialogInterface);
                }
                MessageManager.getInstance().unRegisterTask(2001277);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if8 a;

        public d(if8 if8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if8Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.a.j == null) {
                return;
            }
            this.a.j.onCancel(dialogInterface);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ if8 b;

        public e(if8 if8Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if8Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = if8Var;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.k != null) {
                    this.b.k.dismiss();
                }
                this.a.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends InsertGalleryAsyncTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if8 a;

        public f(if8 if8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = if8Var;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                oi.N(this.a.a, "保存失败！");
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                oi.N(this.a.a, "保存成功！");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ if8 b;

        public g(if8 if8Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if8Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = if8Var;
            this.a = shareItem;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                di.a(this.a.s);
                oi.M(this.b.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f0440);
                dr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(if8 if8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if8Var};
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
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View.OnClickListener a;
        public final /* synthetic */ if8 b;

        public i(if8 if8Var, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if8Var, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = if8Var;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.m();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755620266, "Lcom/repackage/if8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755620266, "Lcom/repackage/if8;");
                return;
            }
        }
        D = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds202);
        E = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    }

    @SuppressLint({"ResourceType"})
    public if8(Context context, boolean z, int i2) {
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
        this.l = 0.33f;
        this.u = new SparseArray<>(8);
        this.v = false;
        this.y = true;
        this.z = 1;
        this.A = true;
        this.B = new a(this, 2001304);
        this.C = 0;
        this.C = i2;
        this.a = context;
        this.g = new ArrayList();
        View r = r();
        this.b = r;
        this.c = r.findViewById(R.id.obfuscated_res_0x7f091ca7);
        this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091ca8);
        String sharePanelText = TbSingleton.getInstance().getSharePanelText();
        if (!TextUtils.isEmpty(sharePanelText)) {
            this.d.setText(sharePanelText);
        }
        ShareGridLayout shareGridLayout = (ShareGridLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091caa);
        this.e = shareGridLayout;
        ViewGroup.LayoutParams layoutParams = shareGridLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int i5 = ShareGridLayout.f;
            marginLayoutParams.leftMargin = i5;
            marginLayoutParams.rightMargin = i5;
            this.e.setLayoutParams(marginLayoutParams);
        }
        this.e.setItemParams(D, E);
        EMTextView eMTextView = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090406);
        this.f = eMTextView;
        eMTextView.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090bab);
        this.n = relativeLayout;
        if (relativeLayout != null) {
            this.o = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091804);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091803);
            this.p = textView;
            textView.setText(R.string.obfuscated_res_0x7f0f0e3b);
            MessageRedDotView messageRedDotView = (MessageRedDotView) this.b.findViewById(R.id.obfuscated_res_0x7f091806);
            this.q = messageRedDotView;
            messageRedDotView.setExtendSize(oi.f(context, R.dimen.tbds5));
            this.q.setTextSize(R.dimen.T_X09);
            this.q.setTextBold(true);
            this.r = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091805);
        }
    }

    public final boolean A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (i2 & 2) > 0 : invokeI.booleanValue;
    }

    public final boolean B(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (i2 & 16) > 0 : invokeI.booleanValue;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n != null : invokeV.booleanValue;
    }

    public final boolean D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? (i2 & 32) > 0 : invokeI.booleanValue;
    }

    public void E(ShareDialogConfig.From from) {
        nx4 sharePanelConfData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, from) == null) && (sharePanelConfData = TbSingleton.getInstance().getSharePanelConfData()) != null && sharePanelConfData.d(from) && sharePanelConfData.c() && !ni.isEmpty(sharePanelConfData.b())) {
            this.d.setText(sharePanelConfData.b());
        }
    }

    public void F(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && C()) {
            if (z) {
                if (i2 <= 0) {
                    this.q.setVisibility(8);
                } else {
                    this.q.setVisibility(0);
                    this.q.f(i2);
                }
                this.q.setVisibility(0);
                return;
            }
            this.q.setVisibility(8);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001277, new b(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void H(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) || onClickListener == null) {
            return;
        }
        this.h = onClickListener;
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
        }
    }

    public void J(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.t = str;
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.y = z;
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.s = z;
        }
    }

    public void M(SparseArray<String> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, sparseArray) == null) {
            this.w = sparseArray;
        }
    }

    public void N(DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onCancelListener) == null) {
            this.j = onCancelListener;
        }
    }

    public void O(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) && C()) {
            this.n.setOnClickListener(new e(this, onClickListener));
        }
    }

    public void P(ShareItem shareItem, boolean z) {
        Location s;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048591, this, shareItem, z) == null) {
            if (z && (s = s()) != null) {
                shareItem.B = s;
            }
            this.u.put(1, shareItem);
            if (StringUtils.isNull(shareItem.n)) {
                return;
            }
            this.d.setText(shareItem.n);
        }
    }

    public void Q(int i2, ShareItem shareItem, boolean z) {
        Location s;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), shareItem, Boolean.valueOf(z)}) == null) {
            if (z && (s = s()) != null) {
                shareItem.B = s;
            }
            this.u.put(i2, shareItem);
        }
    }

    public void R(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.z = i2;
        }
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.A = z;
        }
    }

    public void T(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, window) == null) {
            window.setLayout(-1, -2);
        }
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.z == 2 && l() : invokeV.booleanValue;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (!mi.z()) {
                oi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1125);
            } else if (!sy4.n()) {
                oi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f0e78);
            } else {
                j();
                AlertDialog create = new AlertDialog.Builder(this.a, R.style.obfuscated_res_0x7f100104).create();
                this.k = create;
                create.setCanceledOnTouchOutside(true);
                this.k.setOnDismissListener(new c(this));
                this.k.setOnCancelListener(new d(this));
                Context context = this.a;
                if (context instanceof Activity) {
                    rg.i(this.k, (Activity) context);
                }
                wr4 d2 = wr4.d(this.c);
                d2.n(R.string.J_X14);
                d2.f(R.color.CAM_X0204);
                Window window = this.k.getWindow();
                if (window == null) {
                    return;
                }
                if (this.A) {
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = oi.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ef);
                } else {
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f1003c4);
                }
                window.setGravity(80);
                T(window);
                window.setContentView(this.b);
                window.setDimAmount(this.l);
                k();
                n();
                G();
                f9.a(this.a).registerListener(this.B);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ArrayList arrayList = new ArrayList(this.g);
            this.g.clear();
            if (!z(this.C)) {
                h(R.string.obfuscated_res_0x7f0f1150, new SvgMaskType(R.drawable.obfuscated_res_0x7f080827));
            }
            if (!A(this.C)) {
                h(R.string.obfuscated_res_0x7f0f1157, new SvgMaskType(R.drawable.obfuscated_res_0x7f080823));
            }
            if (!x(this.C)) {
                h(R.string.obfuscated_res_0x7f0f112f, new SvgMaskType(R.drawable.obfuscated_res_0x7f080824));
            }
            if (!y(this.C)) {
                h(R.string.obfuscated_res_0x7f0f1133, new SvgMaskType(R.drawable.obfuscated_res_0x7f080825));
            }
            if (!B(this.C)) {
                h(R.string.obfuscated_res_0x7f0f113e, new SvgMaskType(R.drawable.obfuscated_res_0x7f080828));
            }
            if (D(this.C)) {
                g(R.string.obfuscated_res_0x7f0f1137, R.drawable.obfuscated_res_0x7f08098e);
            }
            if (arrayList.size() > 0) {
                this.g.addAll(arrayList);
            }
            if (this.y) {
                g(R.string.obfuscated_res_0x7f0f1118, R.drawable.obfuscated_res_0x7f08098b);
            }
        }
    }

    public final void X(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, shareItem) == null) || shareItem == null || TextUtils.isEmpty(shareItem.s) || TextUtils.isEmpty(shareItem.r)) {
            return;
        }
        Context context = this.a;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            dr4 dr4Var = new dr4(activity);
            dr4Var.setTitle(shareItem.r);
            dr4Var.setMessage(shareItem.s);
            dr4Var.setAutoNight(false);
            dr4Var.setCancelable(true);
            dr4Var.setTitleShowCenter(true);
            dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1118, new g(this, shareItem));
            dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f1113, new h(this)).create(f9.a(activity));
            dr4Var.show();
        }
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Z(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, objArr) == null) {
            TiebaStatic.eventStat(this.a, str, "click", 1, objArr);
        }
    }

    public final void a0(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048602, this, i2) == null) || i2 > 8 || i2 <= 0) {
            return;
        }
        this.v = true;
        SparseArray<ox4> sparseArray = this.x;
        if (sparseArray != null) {
            ox4 ox4Var = sparseArray.get(i2);
            if (!StringUtils.isNull(ox4Var.b()) && ox4Var.a() != null && ox4Var.a().size() > 0) {
                Z(ox4Var.b(), ox4Var.a());
                return;
            }
        }
        SparseArray<String> sparseArray2 = this.w;
        if (sparseArray2 != null) {
            String str = sparseArray2.get(i2);
            if (ni.isEmpty(str)) {
                return;
            }
            Z(str, new Object[0]);
        }
    }

    public final void b0(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, shareItem) == null) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 7);
            int i2 = shareItem.F;
            if (i2 != 0) {
                param.param("obj_param1", i2);
                int i3 = shareItem.F;
                if (i3 == 2) {
                    param.param("fid", shareItem.J);
                } else if (i3 == 3) {
                    int i4 = shareItem.M;
                    if (i4 != 0) {
                        param.param("obj_type", i4);
                    }
                    param.param("tid", shareItem.K).param("fid", shareItem.J);
                }
            }
            param.param("obj_locate", 9);
            TiebaStatic.log(param);
        }
    }

    public final void c0(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048604, this, i2, str) == null) {
            TiebaStatic.eventStat(this.a, "pb_new_share", null, 1, "loc", Integer.valueOf(i2), PbChosenActivityConfig.KEY_TID, str);
        }
    }

    public final void d0(ShareItem shareItem, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048605, this, shareItem, i2) == null) || shareItem == null) {
            return;
        }
        if (shareItem.q == null) {
            if (shareItem.j) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2).param("obj_source", shareItem.E));
            }
        } else if (shareItem.b) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        } else if (!shareItem.c && !shareItem.f) {
            if (shareItem.d) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).param("tid", shareItem.q).param("obj_type", i2));
            } else if (shareItem.a) {
                c0(i2, shareItem.C);
            } else if (shareItem.e) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_param1", 7).param("obj_type", i2).param("fid", shareItem.q).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
            } else if (shareItem.g) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i2);
                param.param("obj_source", shareItem.E);
                if (!ni.isEmpty(shareItem.t)) {
                    if (shareItem.t.contains("worldcup")) {
                        param.param("obj_param1", 9);
                    }
                    param.param(TiebaStatic.Params.OBJ_URL, shareItem.t);
                }
                TiebaStatic.log(param);
            } else if (shareItem.i) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_TOPIC_DETAIL).param("obj_locate", i2 == 3 ? "1" : i2 == 4 ? "2" : i2 == 9 ? "4" : i2 == 5 ? "3" : i2 == 7 ? "5" : "6").param("topic_id", shareItem.q));
            } else if (shareItem.k) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem.param("tid", shareItem.q);
                statisticItem.param("post_id", shareItem.X);
                statisticItem.param("obj_source", 18);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G);
                TiebaStatic.log(statisticItem);
            } else if (shareItem.l) {
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_GAME_DETIAL);
                statisticItem2.param("obj_type", i2);
                statisticItem2.param("obj_name", shareItem.r);
                TiebaStatic.log(statisticItem2);
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                statisticItem3.param("obj_source", 19);
                TiebaStatic.log(statisticItem3);
            }
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("tid", shareItem.q).param("obj_type", i2).param("obj_source", shareItem.E).param("obj_param1", shareItem.F).param("fid", shareItem.J).param(TiebaStatic.Params.OBJ_PARAM2, shareItem.G));
        }
    }

    public void g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048606, this, i2, i3) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.setOnClickListener(this);
            List<View> list = this.g;
            shareDialogItemView.a();
            list.add(shareDialogItemView);
        }
    }

    public void h(int i2, AbsSvgType absSvgType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048607, this, i2, absSvgType) == null) || absSvgType == null) {
            return;
        }
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
        shareDialogItemView.setItemIcon(absSvgType);
        shareDialogItemView.setItemName(i2);
        shareDialogItemView.setOnClickListener(this);
        List<View> list = this.g;
        shareDialogItemView.a();
        list.add(shareDialogItemView);
    }

    public void i(View view2, int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048608, this, view2, i2, onClickListener) == null) || i2 > this.g.size() || i2 < 0) {
            return;
        }
        this.g.add(i2, view2);
        if (onClickListener != null) {
            view2.setOnClickListener(new i(this, onClickListener));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || Y()) {
            return;
        }
        W();
        if (!sy4.n()) {
            this.e.setVisibility(8);
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            this.e.addView(this.g.get(i2), new ViewGroup.LayoutParams(D, E));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            wr4 d2 = wr4.d(this.c);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColorSelector(this.f, R.color.CAM_X0107);
            if (C()) {
                wr4 d3 = wr4.d(this.n);
                d3.n(R.string.J_X05);
                d3.f(R.color.CAM_X0201);
                this.o.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809be, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
                wr4 d4 = wr4.d(this.p);
                d4.A(R.string.F_X01);
                d4.v(R.color.CAM_X0105);
            }
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.a instanceof Activity) {
                if (this.m == null) {
                    this.m = new PermissionJudgePolicy();
                }
                this.m.clearRequestPermissionList();
                this.m.appendRequestPermission((Activity) this.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                return this.m.startRequestPermission((Activity) this.a);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (alertDialog = this.k) == null) {
            return;
        }
        this.v = false;
        if (this.a instanceof Activity) {
            DialogInterface.OnDismissListener onDismissListener = this.i;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(alertDialog);
            }
            rg.a(this.k, (Activity) this.a);
            MessageManager.getInstance().unRegisterListener(this.B);
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (this.s) {
                this.d.setVisibility(8);
                if (C()) {
                    this.n.setVisibility(0);
                    return;
                }
                return;
            }
            this.d.setVisibility(0);
            if (C()) {
                this.n.setVisibility(8);
            }
        }
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            List<View> list = this.g;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, view2) == null) {
            int id = view2.getId();
            int intValue = view2.getTag() != null ? ((Integer) view2.getTag()).intValue() : -1;
            if (id != R.id.obfuscated_res_0x7f090406 && intValue != R.drawable.obfuscated_res_0x7f08098b && U()) {
                this.v = false;
                return;
            }
            if (intValue != R.drawable.obfuscated_res_0x7f08098e) {
                m();
            }
            if (this.u.size() == 0) {
                return;
            }
            if (id == R.id.obfuscated_res_0x7f090406 || !this.v) {
                this.v = true;
                ShareItem t = t(1);
                sy4 sy4Var = new sy4(this.a, null);
                if (t != null && t.n0) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_AI_APP_SHARE_CLICK).param("obj_id", t.o0).param("obj_type", t.p0).param("obj_source", t.q0));
                    Bundle bundle = new Bundle();
                    bundle.putInt("source", 16);
                    t.k(bundle);
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                    statisticItem.param("obj_source", 25);
                    TiebaStatic.log(statisticItem);
                }
                if (id == R.id.obfuscated_res_0x7f090406) {
                    Z("share_cancel", new Object[0]);
                    if (t != null && t.g) {
                        d0(t, 16);
                    }
                    DialogInterface.OnCancelListener onCancelListener = this.j;
                    if (onCancelListener != null) {
                        onCancelListener.onCancel(this.k);
                        return;
                    }
                    return;
                }
                if (t != null && t.l0) {
                    StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD);
                    statisticItem2.param("obj_source", 31);
                    TiebaStatic.log(statisticItem2);
                }
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
                statisticItem3.param("obj_param1", this.t);
                if (intValue == R.drawable.obfuscated_res_0x7f080827) {
                    if (!mi.z()) {
                        oi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1125);
                        return;
                    }
                    Z("share_to_weixin", new Object[0]);
                    a0(3);
                    t = t(3);
                    d0(t, 4);
                    if (t != null) {
                        if (w(t) && t.a() != null && t.a().contains(3)) {
                            my4.e(t, this.a, 3, this.j);
                        } else if (t.j0 == 1) {
                            X(t);
                        } else {
                            sy4Var.t(t);
                        }
                    }
                    statisticItem3.param("obj_type", 2);
                } else if (intValue == R.drawable.obfuscated_res_0x7f080823) {
                    if (!mi.z()) {
                        oi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1125);
                        return;
                    }
                    Z("share_to_pyq", new Object[0]);
                    a0(2);
                    t = t(2);
                    d0(t, 3);
                    if (t != null) {
                        if (w(t) && t.a() != null && t.a().contains(2)) {
                            my4.e(t, this.a, 2, this.j);
                        } else if (t.j0 == 1) {
                            X(t);
                        } else {
                            if (t.b) {
                                t.s = "【" + t.r + "】 " + t.s;
                            }
                            sy4Var.u(t);
                        }
                    }
                    statisticItem3.param("obj_type", 3);
                } else if (intValue == R.drawable.obfuscated_res_0x7f080825) {
                    if (!mi.z()) {
                        oi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1125);
                        return;
                    }
                    if (zj8.b(this.a, "com.tencent.mobileqq")) {
                        Z("share_to_qzone", new Object[0]);
                        a0(4);
                        t = t(4);
                        d0(t, 5);
                        if (t != null) {
                            if (w(t) && t.a() != null && t.a().contains(4)) {
                                my4.e(t, this.a, 4, this.j);
                            } else {
                                sy4Var.p(t);
                            }
                        }
                    } else {
                        Context context = this.a;
                        BdToast.c(context, context.getText(R.string.obfuscated_res_0x7f0f1130)).q();
                    }
                    statisticItem3.param("obj_type", 5);
                } else if (intValue == R.drawable.icon_qq_weibo) {
                    if (!mi.z()) {
                        oi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1125);
                        return;
                    }
                    Z("share_to_qweibo", new Object[0]);
                    a0(5);
                    t = t(5);
                    if (t != null) {
                        if (!t.a) {
                            t.s = p(t);
                        }
                        sy4Var.s(t);
                    }
                } else if (intValue == R.drawable.obfuscated_res_0x7f080828) {
                    if (!mi.z()) {
                        oi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1125);
                        return;
                    }
                    Z("share_to_sweibo", new Object[0]);
                    a0(6);
                    t = t(6);
                    d0(t, 7);
                    if (t != null) {
                        if (!t.a) {
                            t.s = p(t);
                        }
                        if (w(t) && t.a() != null && t.a().contains(4)) {
                            my4.e(t, this.a, 6, this.j);
                        } else {
                            sy4Var.r(t);
                        }
                    }
                    statisticItem3.param("obj_type", 6);
                } else if (intValue == R.drawable.icon_renren) {
                    if (!mi.z()) {
                        oi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1125);
                        return;
                    }
                    Z("share_to_renren", new Object[0]);
                    a0(7);
                    t = t(7);
                    if (t != null) {
                        if (!t.a) {
                            t.s = p(t);
                        }
                        sy4Var.q(t);
                    }
                } else if (intValue == R.drawable.obfuscated_res_0x7f080824) {
                    if (!mi.z()) {
                        oi.M(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f1125);
                        return;
                    }
                    if (zj8.b(this.a, "com.tencent.mobileqq")) {
                        Z("share_to_qq_friend", new Object[0]);
                        a0(8);
                        t = t(8);
                        d0(t, 9);
                        if (t != null) {
                            if (w(t) && t.a() != null && t.a().contains(4)) {
                                my4.e(t, this.a, 8, this.j);
                            } else {
                                sy4Var.o(t);
                            }
                        }
                    } else {
                        Context context2 = this.a;
                        BdToast.c(context2, context2.getText(R.string.obfuscated_res_0x7f0f1130)).q();
                    }
                    statisticItem3.param("obj_type", 4);
                } else if (intValue == R.drawable.obfuscated_res_0x7f08098e) {
                    if (this.m == null) {
                        this.m = new PermissionJudgePolicy();
                    }
                    this.m.clearRequestPermissionList();
                    this.m.appendRequestPermission((Activity) this.a, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.m.startRequestPermission((Activity) this.a)) {
                        this.v = false;
                        return;
                    }
                    m();
                    d0(t, 17);
                    if (FileHelper.isLocalFile(t.v)) {
                        if (FileHelper.copyImageFile(FileHelper.getImageRealPathFromUri(this.a, t.v), UUID.randomUUID().toString().replace("-", "").toLowerCase(), this.a) == 0) {
                            oi.N(this.a, "保存成功！");
                        } else {
                            oi.N(this.a, "保存失败！");
                        }
                    } else {
                        Uri uri = t.v;
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
                } else if (intValue == R.drawable.obfuscated_res_0x7f08098b) {
                    d0(t, 10);
                    View.OnClickListener onClickListener = this.h;
                    if (onClickListener != null) {
                        onClickListener.onClick(view2);
                    } else {
                        di.a(t.t);
                        oi.N(this.a.getApplicationContext(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f043f));
                    }
                    b0(t);
                    if (t != null && t.a) {
                        c0(8, t.C);
                    }
                    statisticItem3.param("obj_type", 8);
                }
                statisticItem3.param("obj_source", 6);
                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (t != null) {
                    statisticItem3.param("fid", t.q);
                    statisticItem3.param("fname", t.p);
                }
                TiebaStatic.log(statisticItem3);
            }
        }
    }

    public final String p(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, shareItem)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(shareItem.r)) {
                sb.append("【");
                sb.append(shareItem.r);
                sb.append("】 ");
            }
            if (!TextUtils.isEmpty(shareItem.r)) {
                sb.append(shareItem.s);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d021a, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final Location s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? mz5.b() : (Location) invokeV.objValue;
    }

    public ShareItem t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) {
            ShareItem shareItem = this.u.get(i2);
            return shareItem == null ? this.u.get(1) : shareItem;
        }
        return (ShareItem) invokeI.objValue;
    }

    public void u(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, onDismissListener) == null) || onDismissListener == null) {
            return;
        }
        this.i = onDismissListener;
    }

    public LinearLayout v(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048621, this, i2, i3)) == null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.a);
            shareDialogItemView.setItemIcon(i3, SkinManager.getColor(R.color.CAM_X0107));
            shareDialogItemView.setItemName(i2);
            shareDialogItemView.a();
            return shareDialogItemView;
        }
        return (LinearLayout) invokeII.objValue;
    }

    public final boolean w(ShareItem shareItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, shareItem)) == null) ? (TextUtils.isEmpty(shareItem.t0) || TextUtils.isEmpty(shareItem.u0)) ? false : true : invokeL.booleanValue;
    }

    public final boolean x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) ? (i2 & 8) > 0 : invokeI.booleanValue;
    }

    public final boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i2)) == null) ? (i2 & 4) > 0 : invokeI.booleanValue;
    }

    public final boolean z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i2)) == null) ? (i2 & 1) > 0 : invokeI.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public if8(Context context) {
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
