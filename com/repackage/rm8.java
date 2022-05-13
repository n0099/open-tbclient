package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rm8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MainTabActivity a;
    public PopupWindow b;
    public FragmentTabHost c;
    public String d;
    public long e;
    public View f;
    public TextView g;
    public TextView h;
    public Runnable i;
    public Runnable j;
    public View.OnClickListener k;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm8 a;

        public a(rm8 rm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rm8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.c == null || this.a.b == null || this.a.b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.a.c.getFragmentTabWidget();
            int k = mi.k(this.a.a.getActivity());
            int f = mi.f(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f070294);
            this.a.b.getContentView().measure(0, 0);
            pg.l(this.a.b, fragmentTabWidget, (k - mi.f(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f0702c4)) / 2, -f);
            iu4.k().x("home_tip", this.a.e);
            ng.a().postDelayed(this.a.j, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 1));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm8 a;

        public b(rm8 rm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rm8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm8 a;

        public c(rm8 rm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rm8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h();
                if (WriteActivityConfig.isAsyncWriting()) {
                    return;
                }
                WriteActivityConfig.newInstance(this.a.a).setType(9).setTitle(this.a.d).setForumId("0").send();
                TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 1));
            }
        }
    }

    public rm8(MainTabActivity mainTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new a(this);
        this.j = new b(this);
        this.k = new c(this);
        this.a = mainTabActivity;
        this.c = (FragmentTabHost) mainTabActivity.findViewById(R.id.obfuscated_res_0x7f091e88);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            pg.c(this.b);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ng.a().removeCallbacks(this.i);
            ng.a().removeCallbacks(this.j);
            g();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h();
        }
    }

    public void j(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Long.valueOf(j)}) == null) || iu4.k().m("home_tip", 0L) == j || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.d = str2;
        this.e = j;
        if (this.f == null) {
            View inflate = LayoutInflater.from(this.a.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d0830, (ViewGroup) null);
            this.f = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09206c);
            this.h = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09206e);
            this.f.setOnClickListener(this.k);
        }
        this.g.setText(StringHelper.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
        this.h.setText(R.string.obfuscated_res_0x7f0f1434);
        if (this.b == null) {
            this.b = new PopupWindow(this.f, -2, -2);
        } else {
            h();
        }
        ng.a().removeCallbacks(this.i);
        ng.a().postDelayed(this.i, 100L);
    }
}
