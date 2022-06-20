package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yq4;
import java.util.List;
/* loaded from: classes6.dex */
public class nc8 extends pc8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int l0;
    public static final int m0;
    public static final int n0;
    public transient /* synthetic */ FieldHolder $fh;
    public Context R;
    public LinearLayout S;
    public LinearLayout T;
    public View U;
    public View V;
    public String W;
    public boolean X;
    public boolean Y;
    public yq4.d Z;
    public yq4.d g0;
    public yq4.d h0;
    public yq4.d i0;
    public yq4.d j0;
    public View.OnClickListener k0;

    /* loaded from: classes6.dex */
    public class a extends ShareDialogItemView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context l;
        public EMTextView m;
        public LinearLayout.LayoutParams n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(nc8 nc8Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nc8Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = context;
        }

        @Override // com.baidu.tieba.sharesdk.view.ShareDialogItemView
        public ShareDialogItemView a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                super.a();
                addView(this.m, this.n);
                return this;
            }
            return (ShareDialogItemView) invokeV.objValue;
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.c = new ImageView(this.l);
                setTag(Integer.valueOf(i));
                this.c.setScaleType(ImageView.ScaleType.FIT_XY);
                WebPManager.setMaskDrawable(this.c, i, null);
                b();
            }
        }

        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                EMTextView eMTextView = new EMTextView(this.l);
                this.m = eMTextView;
                eMTextView.setTextSize(0, ShareDialogItemView.j);
                this.m.setText(i);
                SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0107);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                this.n = layoutParams;
                layoutParams.topMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_T_X001);
                this.n.gravity = 1;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755474194, "Lcom/repackage/nc8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755474194, "Lcom/repackage/nc8;");
                return;
            }
        }
        l0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds187);
        m0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds239);
        n0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds34);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nc8(Context context, String str, boolean z, boolean z2, yq4.d dVar, yq4.d dVar2, yq4.d dVar3, yq4.d dVar4, yq4.d dVar5, View.OnClickListener onClickListener) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, str, Boolean.valueOf(z), Boolean.valueOf(z2), dVar, dVar2, dVar3, dVar4, dVar5, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.R = context;
        this.W = str;
        this.X = z;
        this.Y = z2;
        this.Z = dVar;
        this.g0 = dVar2;
        this.h0 = dVar3;
        this.i0 = dVar4;
        this.j0 = dVar5;
        this.k0 = onClickListener;
        this.S = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09097b);
        this.T = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091c3c);
        x0();
    }

    @Override // com.repackage.pc8
    public View A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d03bf, (ViewGroup) null) : (View) invokeV.objValue;
    }

    @Override // com.repackage.pc8
    public void m(View view2, int i, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, onClickListener) == null) {
            super.m(view2, i, onClickListener);
        }
    }

    @Override // com.repackage.pc8, android.view.View.OnClickListener
    public void onClick(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.onClick(view2);
            int intValue = view2.getTag() != null ? ((Integer) view2.getTag()).intValue() : -1;
            if (intValue == R.drawable.obfuscated_res_0x7f0809a3) {
                yq4.d dVar = this.h0;
                if (dVar != null) {
                    dVar.onClick();
                }
            } else if (intValue == -32040384) {
                yq4.d dVar2 = this.Z;
                if (dVar2 != null) {
                    dVar2.onClick();
                }
            } else if (intValue == R.drawable.obfuscated_res_0x7f080a2d) {
                yq4.d dVar3 = this.g0;
                if (dVar3 != null) {
                    dVar3.onClick();
                }
            } else if (intValue == R.drawable.obfuscated_res_0x7f080a2f) {
                yq4.d dVar4 = this.i0;
                if (dVar4 != null) {
                    dVar4.onClick();
                }
            } else if (intValue == R.drawable.obfuscated_res_0x7f080a2e) {
                yq4.d dVar5 = this.j0;
                if (dVar5 != null) {
                    dVar5.onClick();
                }
            } else if (intValue != R.drawable.obfuscated_res_0x7f080a3b || (onClickListener = this.k0) == null) {
            } else {
                onClickListener.onClick(view2);
            }
        }
    }

    @Override // com.repackage.pc8
    public boolean r0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.S.removeAllViews();
            this.T.removeAllViews();
            int i2 = 0;
            while (true) {
                if (i2 >= Math.min(6, this.h.size())) {
                    break;
                }
                this.S.addView(this.h.get(i2), new ViewGroup.LayoutParams(l0, m0));
                i2++;
            }
            this.S.addView(this.U, new ViewGroup.LayoutParams(n0, -1));
            for (i = 6; i < this.h.size(); i++) {
                this.T.addView(this.h.get(i), new ViewGroup.LayoutParams(l0, m0));
            }
            this.T.addView(this.V, new ViewGroup.LayoutParams(n0, -1));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.h.clear();
            l(R.string.obfuscated_res_0x7f0f1167, new SvgMaskType(R.drawable.obfuscated_res_0x7f0807f8));
            l(R.string.obfuscated_res_0x7f0f116b, new SvgMaskType(R.drawable.obfuscated_res_0x7f0807f9));
            l(R.string.obfuscated_res_0x7f0f1188, new SvgMaskType(R.drawable.obfuscated_res_0x7f0807fb));
            a aVar = new a(this, this.R);
            aVar.d(R.drawable.obfuscated_res_0x7f080a3b);
            aVar.setItemName(R.string.obfuscated_res_0x7f0f1189);
            aVar.e(R.string.obfuscated_res_0x7f0f118a);
            aVar.setOnClickListener(this);
            List<View> list = this.h;
            aVar.a();
            list.add(aVar);
            l(R.string.obfuscated_res_0x7f0f118f, new SvgMaskType(R.drawable.obfuscated_res_0x7f0807f7));
            l(R.string.obfuscated_res_0x7f0f1176, new SvgMaskType(R.drawable.obfuscated_res_0x7f0807fc));
            if (this.W != null) {
                i(R.string.obfuscated_res_0x7f0f0d0a, R.drawable.obfuscated_res_0x7f0809a3);
            }
            LinearLayout F = F(R.string.obfuscated_res_0x7f0f10a2, R.drawable.obfuscated_res_0x7f08099e);
            F.setOnClickListener(this);
            F.setTag(-32040384);
            this.h.add(F);
            if (this.X) {
                i(R.string.obfuscated_res_0x7f0f10a1, R.drawable.obfuscated_res_0x7f080a2d);
            }
            i(R.string.obfuscated_res_0x7f0f08a3, R.drawable.obfuscated_res_0x7f080a2f);
            if (this.Y) {
                i(R.string.obfuscated_res_0x7f0f08c9, R.drawable.obfuscated_res_0x7f080a2e);
            }
            this.U = new View(this.R);
            this.V = new View(this.R);
        }
    }
}
