package d.a.q0.k3;

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
import d.a.d.e.m.g;
import d.a.d.e.p.l;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f60065a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f60066b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f60067c;

    /* renamed from: d  reason: collision with root package name */
    public String f60068d;

    /* renamed from: e  reason: collision with root package name */
    public long f60069e;

    /* renamed from: f  reason: collision with root package name */
    public View f60070f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60071g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60072h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f60073i;
    public Runnable j;
    public View.OnClickListener k;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60074e;

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
            this.f60074e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60074e.f60067c == null || this.f60074e.f60066b == null || this.f60074e.f60066b.getContentView() == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = this.f60074e.f60067c.getFragmentTabWidget();
            int k = l.k(this.f60074e.f60065a.getActivity());
            int g2 = l.g(this.f60074e.f60065a.getActivity(), R.dimen.ds278);
            this.f60074e.f60066b.getContentView().measure(0, 0);
            g.l(this.f60074e.f60066b, fragmentTabWidget, (k - l.g(this.f60074e.f60065a.getActivity(), R.dimen.ds430)) / 2, -g2);
            d.a.p0.s.d0.b.j().w("home_tip", this.f60074e.f60069e);
            d.a.d.e.m.e.a().postDelayed(this.f60074e.j, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 1));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60075e;

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
            this.f60075e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60075e.g();
            }
        }
    }

    /* renamed from: d.a.q0.k3.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1517c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f60076e;

        public View$OnClickListenerC1517c(c cVar) {
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
            this.f60076e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f60076e.h();
                if (WriteActivityConfig.isAsyncWriting()) {
                    return;
                }
                WriteActivityConfig.newInstance(this.f60076e.f60065a).setType(9).setTitle(this.f60076e.f60068d).setForumId("0").send();
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
        this.f60073i = new a(this);
        this.j = new b(this);
        this.k = new View$OnClickListenerC1517c(this);
        this.f60065a = mainTabActivity;
        this.f60067c = (FragmentTabHost) mainTabActivity.findViewById(R.id.tab_host);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g.c(this.f60066b);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.d.e.m.e.a().removeCallbacks(this.f60073i);
            d.a.d.e.m.e.a().removeCallbacks(this.j);
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
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Long.valueOf(j)}) == null) || d.a.p0.s.d0.b.j().l("home_tip", 0L) == j || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return;
        }
        this.f60068d = str2;
        this.f60069e = j;
        if (this.f60070f == null) {
            View inflate = LayoutInflater.from(this.f60065a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
            this.f60070f = inflate;
            this.f60071g = (TextView) inflate.findViewById(R.id.tips);
            this.f60072h = (TextView) this.f60070f.findViewById(R.id.tips_content);
            this.f60070f.setOnClickListener(this.k);
        }
        this.f60071g.setText(StringHelper.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
        this.f60072h.setText(R.string.topic_join);
        if (this.f60066b == null) {
            this.f60066b = new PopupWindow(this.f60070f, -2, -2);
        } else {
            h();
        }
        d.a.d.e.m.e.a().removeCallbacks(this.f60073i);
        d.a.d.e.m.e.a().postDelayed(this.f60073i, 100L);
    }
}
