package d.a.s0.k3;

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
import d.a.c.e.m.g;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f62688a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f62689b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f62690c;

    /* renamed from: d  reason: collision with root package name */
    public String f62691d;

    /* renamed from: e  reason: collision with root package name */
    public long f62692e;

    /* renamed from: f  reason: collision with root package name */
    public View f62693f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62694g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62695h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f62696i;
    public Runnable j;
    public View.OnClickListener k;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f62697e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62697e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62697e.f62690c == null || this.f62697e.f62689b == null || this.f62697e.f62689b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f62697e.f62690c.getFragmentTabWidget();
            int k = l.k(this.f62697e.f62688a.getActivity());
            int g2 = l.g(this.f62697e.f62688a.getActivity(), R.dimen.ds278);
            this.f62697e.f62689b.getContentView().measure(0, 0);
            g.l(this.f62697e.f62689b, fragmentTabWidget, (k - l.g(this.f62697e.f62688a.getActivity(), R.dimen.ds430)) / 2, -g2);
            d.a.r0.r.d0.b.j().w("home_tip", this.f62697e.f62692e);
            d.a.c.e.m.e.a().postDelayed(this.f62697e.j, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 1));
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f62698e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62698e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62698e.g();
            }
        }
    }

    /* renamed from: d.a.s0.k3.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1556c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f62699e;

        public View$OnClickListenerC1556c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62699e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f62699e.h();
                if (WriteActivityConfig.isAsyncWriting()) {
                    return;
                }
                WriteActivityConfig.newInstance(this.f62699e.f62688a).setType(9).setTitle(this.f62699e.f62691d).setForumId("0").send();
                TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 1));
            }
        }
    }

    public c(MainTabActivity mainTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62696i = new a(this);
        this.j = new b(this);
        this.k = new View$OnClickListenerC1556c(this);
        this.f62688a = mainTabActivity;
        this.f62690c = (FragmentTabHost) mainTabActivity.findViewById(R.id.tab_host);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g.c(this.f62689b);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f62696i);
            d.a.c.e.m.e.a().removeCallbacks(this.j);
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
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Long.valueOf(j)}) == null) || d.a.r0.r.d0.b.j().l("home_tip", 0L) == j || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.f62691d = str2;
        this.f62692e = j;
        if (this.f62693f == null) {
            View inflate = LayoutInflater.from(this.f62688a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
            this.f62693f = inflate;
            this.f62694g = (TextView) inflate.findViewById(R.id.tips);
            this.f62695h = (TextView) this.f62693f.findViewById(R.id.tips_content);
            this.f62693f.setOnClickListener(this.k);
        }
        this.f62694g.setText(StringHelper.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
        this.f62695h.setText(R.string.topic_join);
        if (this.f62689b == null) {
            this.f62689b = new PopupWindow(this.f62693f, -2, -2);
        } else {
            h();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.f62696i);
        d.a.c.e.m.e.a().postDelayed(this.f62696i, 100L);
    }
}
