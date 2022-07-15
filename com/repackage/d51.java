package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d51 extends z41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView f;
    public final RelativeLayout g;
    public final kj0<?> h;
    public ej0 i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d51 a;

        public a(d51 d51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d51Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i == null) {
                return;
            }
            this.a.i.m();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ij0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ si0 b;
        public final /* synthetic */ d51 c;

        public b(d51 d51Var, AdBaseModel adBaseModel, si0 si0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d51Var, adBaseModel, si0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = d51Var;
            this.a = adBaseModel;
            this.b = si0Var;
        }

        @Override // com.repackage.ij0
        public void a(AdDownloadStatus adDownloadStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, adDownloadStatus) == null) {
                int i = c.a[adDownloadStatus.ordinal()];
                if (i == 1) {
                    d51 d51Var = this.c;
                    if (d51Var.e == null || !d51Var.n(this.a)) {
                        return;
                    }
                    this.c.e.f(this.a, this.b.i);
                } else if (i == 2) {
                    d51 d51Var2 = this.c;
                    if (d51Var2.e == null || !d51Var2.n(this.a)) {
                        return;
                    }
                    this.c.e.d(this.a);
                } else if (i == 3) {
                    d51 d51Var3 = this.c;
                    if (d51Var3.e == null || !d51Var3.n(this.a)) {
                        return;
                    }
                    this.c.e.e(this.a);
                } else if (i != 4) {
                } else {
                    d51 d51Var4 = this.c;
                    if (d51Var4.e == null || !d51Var4.n(this.a)) {
                        return;
                    }
                    this.c.e.a(this.a);
                }
            }
        }

        @Override // com.repackage.ij0
        public void b(AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) {
                if ((!(adDownloadCode != AdDownloadCode.ERROR_FAST_CLICK) || !(this.c.e != null)) || !this.c.n(this.a)) {
                    return;
                }
                this.c.e.b(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-490228398, "Lcom/repackage/d51$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-490228398, "Lcom/repackage/d51$c;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadStatus.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d51(int i, View view2) {
        super(i, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = (TextView) a(R.id.obfuscated_res_0x7f090961);
        this.g = (RelativeLayout) a(R.id.obfuscated_res_0x7f09152d);
        view2.setBackgroundColor(0);
        this.h = yj0.a(this.g, IDownloadViewCreator.ViewType.FEED_DOWNLOAD_VIEW);
        this.g.setOnClickListener(new a(this));
        m();
    }

    @Override // com.repackage.z41
    public void e() {
        ej0 ej0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ej0Var = this.i) == null) {
            return;
        }
        ej0Var.k();
        this.i = null;
    }

    public final void m() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f) == null) {
            return;
        }
        textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060254));
    }

    public final boolean n(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        xm0 xm0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel)) == null) {
            if (adBaseModel == null || (xm0Var = adBaseModel.l) == null) {
                return false;
            }
            return xm0Var.e;
        }
        return invokeL.booleanValue;
    }

    public final void o(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || this.f == null) {
            return;
        }
        this.f.setTextColor(getResources().getColor(adBaseModel.b ? R.color.obfuscated_res_0x7f060284 : R.color.obfuscated_res_0x7f060254));
    }

    @Override // com.repackage.z41
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            if (z41.c(adBaseModel) && adBaseModel.h != null) {
                m();
                String str = adBaseModel.h.b.a;
                if (!TextUtils.isEmpty(str) && (textView = this.f) != null) {
                    textView.setText(str);
                    o(adBaseModel);
                }
                if (TextUtils.isEmpty(adBaseModel.f.d)) {
                    return;
                }
                si0 b2 = si0.b(adBaseModel);
                this.i = new ej0(b2, this.h);
                q41 q41Var = this.e;
                if (q41Var != null) {
                    q41Var.c(adBaseModel);
                }
                this.i.o(new b(this, adBaseModel, b2));
                return;
            }
            i(8);
        }
    }
}
