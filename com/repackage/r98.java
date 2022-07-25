package com.repackage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ActionControl;
import tbclient.AdCloseInfo;
/* loaded from: classes7.dex */
public class r98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PlaceId A;
    public View.OnClickListener B;
    public View.OnClickListener C;
    public PopupWindow.OnDismissListener D;
    public final CustomMessageListener E;
    public View.OnClickListener F;
    public final View a;
    public Context b;
    public PopupWindow c;
    public PopupWindow d;
    public LinearLayout e;
    public TBSpecificationBtn f;
    public vu4 g;
    public TextView h;
    public RelativeLayout i;
    public EMTextView j;
    public ImageView k;
    public TextView l;
    public List<CheckBox> m;
    public AdvertAppInfo n;
    public ActionControl o;
    public List<String> p;
    public String q;
    public String r;
    public int s;
    public int t;
    public View u;
    public int v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r98 a;

        public a(r98 r98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int k = this.a.k();
                if (k > 0) {
                    r98 r98Var = this.a;
                    r98Var.f.setText(r98Var.b.getResources().getString(R.string.obfuscated_res_0x7f0f0426));
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) this.a.b.getString(R.string.obfuscated_res_0x7f0f00a6));
                    int color = SkinManager.getColor(R.color.CAM_X0105);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, spannableStringBuilder.length(), 17);
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) String.valueOf(k));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)), length, spannableStringBuilder.length(), 17);
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) this.a.b.getString(R.string.obfuscated_res_0x7f0f00a5));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 17);
                    this.a.h.setText(spannableStringBuilder);
                    return;
                }
                r98 r98Var2 = this.a;
                r98Var2.f.setText(r98Var2.b.getResources().getString(R.string.obfuscated_res_0x7f0f00b5));
                r98 r98Var3 = this.a;
                r98Var3.h.setText(r98Var3.q);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r98 a;

        public b(r98 r98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.n == null) {
                return;
            }
            r98 r98Var = this.a;
            if (r98Var.c == null) {
                return;
            }
            String n = r98Var.n();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, this.a.n.a));
            this.a.l();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_CLOSE, "http://afd.baidu.com/afd/close");
            tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AD_CLOSE);
            httpMessage.addParam("pi", this.a.A.value);
            httpMessage.addParam("cr", n);
            httpMessage.addParam("ext", this.a.n.g);
            httpMessage.addParam("ci", TbadkCoreApplication.getInst().getCuid());
            MessageManager.getInstance().sendMessage(httpMessage, tbHttpMessageTask);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r98 a;

        public c(r98 r98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r98Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            PopupWindow popupWindow;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (popupWindow = this.a.d) == null) {
                return;
            }
            popupWindow.dismiss();
            this.a.d = null;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r98 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(r98 r98Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r98Var, Integer.valueOf(i)};
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
            this.a = r98Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.l();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r98 a;

        public e(r98 r98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r98 a;

        public f(r98 r98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l();
            }
        }
    }

    public r98(@NonNull AdvertAppInfo advertAppInfo, @NonNull AdCloseInfo adCloseInfo, @NonNull Context context, View view2, int i, PlaceId placeId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {advertAppInfo, adCloseInfo, context, view2, Integer.valueOf(i), placeId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.m = null;
        this.p = new ArrayList();
        this.z = false;
        this.B = new a(this);
        this.C = new b(this);
        this.D = new c(this);
        this.E = new d(this, 2016524);
        this.F = new e(this);
        this.n = advertAppInfo;
        this.b = context;
        this.a = view2;
        this.A = placeId;
        this.y = i;
        gd7.c(this.p);
        if (adCloseInfo != null) {
            this.o = adCloseInfo.action_control;
            for (String str : adCloseInfo.reasons) {
                gd7.a(this.p, str);
            }
            String str2 = adCloseInfo.title;
            this.q = str2;
            if (TextUtils.isEmpty(str2)) {
                this.q = this.b.getString(R.string.obfuscated_res_0x7f0f1370);
            }
            this.r = adCloseInfo.confirm_title;
        }
        this.s = pi.f(this.b, R.dimen.obfuscated_res_0x7f070291);
        this.t = pi.k(this.b) - (this.w * 2);
        this.v = pi.f(this.b, R.dimen.obfuscated_res_0x7f07023c);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || gd7.e(this.p)) {
            return;
        }
        int i = gd7.i(this.p);
        this.e.setVisibility(0);
        int i2 = 0;
        for (int i3 = 0; i3 < Math.ceil(i / 2.0d); i3++) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0066, (ViewGroup) null);
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 1;
            if (i3 != 0) {
                layoutParams.topMargin = pi.f(this.b, R.dimen.M_H_X003);
            }
            linearLayout.setLayoutParams(layoutParams);
            this.e.addView(linearLayout);
            for (int i4 = 0; i4 < linearLayout.getChildCount() && (i2 = i2 + 1) <= i; i4++) {
                CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i4);
                checkBox.setOnClickListener(this.B);
                checkBox.setVisibility(0);
                gd7.a(this.m, checkBox);
            }
        }
        for (int i5 = 0; i5 < gd7.i(this.p); i5++) {
            String str = (String) gd7.d(this.p, i5);
            CheckBox checkBox2 = (CheckBox) gd7.d(this.m, i5);
            if (checkBox2 != null) {
                checkBox2.setText(str);
            }
        }
    }

    public final boolean i(Context context, View view2, int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) {
            if (context == null || view2 == null || iArr == null || iArr.length != 2) {
                return false;
            }
            int[] iArr2 = new int[2];
            view2.getLocationOnScreen(iArr2);
            int height = view2.getHeight();
            int i5 = pi.i(context);
            int k = pi.k(context);
            boolean z = ((i5 - iArr2[1]) - height) - i3 < i;
            iArr[0] = k - i2;
            if (z) {
                iArr[1] = (iArr2[1] - i) - i4;
            } else {
                iArr[1] = iArr2[1] + height + i4;
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ActionControl actionControl = this.o;
            return (actionControl == null || TextUtils.isEmpty(actionControl.url) || TextUtils.isEmpty(this.o.name)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (gd7.e(this.m)) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < gd7.i(this.m); i2++) {
                CheckBox checkBox = (CheckBox) gd7.d(this.m, i2);
                if (checkBox != null && checkBox.isChecked()) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PopupWindow popupWindow = this.c;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.c = null;
            }
            PopupWindow popupWindow2 = this.d;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.d = null;
            }
        }
    }

    public final View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Context context = this.b;
            if (context == null) {
                return null;
            }
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0065, (ViewGroup) null);
            this.h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090cd6);
            this.i = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092130);
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0900df);
            this.j = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0900de);
            this.k = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0902a7);
            if (!TextUtils.isEmpty(this.q)) {
                this.h.setText(this.q);
            }
            this.f = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f0909ea);
            vu4 vu4Var = new vu4();
            this.g = vu4Var;
            vu4Var.r(R.color.CAM_X0304);
            this.f.setConfig(this.g);
            if (!TextUtils.isEmpty(this.r)) {
                this.f.setText(this.r);
            } else {
                this.f.setText(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f00b5));
            }
            this.f.setOnClickListener(this.C);
            if (j()) {
                this.j.setText(this.o.name);
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(this.F);
            }
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            this.k.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_ad_dislike_arrow20_right_n));
            this.e = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091a3f);
            this.m = new ArrayList();
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09046f);
            this.l = textView;
            textView.setVisibility(0);
            this.l.setOnClickListener(new f(this));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.n == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (!gd7.e(this.m)) {
                for (int i = 0; i < gd7.i(this.m); i++) {
                    CheckBox checkBox = (CheckBox) gd7.d(this.m, i);
                    if (checkBox != null && checkBox.isChecked() && gd7.i(this.p) > i) {
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append((String) gd7.d(this.p, i));
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            View view2 = this.u;
            if (view2 == null) {
                return 0;
            }
            try {
                view2.measure(0, 0);
                return this.u.getMeasuredHeight();
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && j()) {
            ik5.l().c(this.b, new String[]{this.o.url}, null);
        }
    }

    public void q() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (context = this.b) == null || FullBrowseHelper.checkAndShowFullBrowseModeDialog(h9.a(context), null)) {
            return;
        }
        l();
        View m = m();
        h();
        this.u = m;
        this.s = o();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
        gradientDrawable.setCornerRadius(pi.f(this.b, R.dimen.tbds31));
        this.u.setBackgroundDrawable(gradientDrawable);
        PopupWindow popupWindow = new PopupWindow(m, this.t, this.s);
        this.c = popupWindow;
        popupWindow.setFocusable(true);
        this.c.setTouchable(true);
        this.c.setSoftInputMode(16);
        this.c.setOnDismissListener(this.D);
        if (Build.VERSION.SDK_INT >= 22) {
            this.c.setAttachedInDecor(false);
        }
        if (!this.z) {
            MessageManager.getInstance().registerListener(this.E);
            this.z = true;
        }
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d08a1, (ViewGroup) null), -1, -1);
        this.d = popupWindow2;
        popupWindow2.setFocusable(false);
        this.d.setTouchable(false);
        if (Build.VERSION.SDK_INT >= 22) {
            this.d.setAttachedInDecor(false);
        }
        this.d.showAtLocation(this.a, this.y, 0, 0);
        int[] iArr = new int[2];
        i(this.b, this.a, this.s, this.t, this.v, this.x, iArr);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return;
        }
        this.c.setBackgroundDrawable(new ColorDrawable(0));
        this.c.showAtLocation(this.a, this.y, iArr[0] - this.w, iArr[1]);
    }
}
