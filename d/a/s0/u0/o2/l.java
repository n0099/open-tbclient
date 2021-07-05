package d.a.s0.u0.o2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f66694a;

    /* renamed from: b  reason: collision with root package name */
    public PopupWindow f66695b;

    /* renamed from: c  reason: collision with root package name */
    public View f66696c;

    /* renamed from: d  reason: collision with root package name */
    public FrsViewData f66697d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.u0.m1.e.d f66698e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f66699f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f66700g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f66701h;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f66702e;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66702e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f66702e.f66694a == null || this.f66702e.f66696c == null || this.f66702e.f66695b == null || this.f66702e.f66695b.getContentView() == null) {
                return;
            }
            int g2 = d.a.c.e.p.l.g(this.f66702e.f66694a, R.dimen.ds270);
            this.f66702e.f66695b.getContentView().measure(0, 0);
            d.a.c.e.m.g.l(this.f66702e.f66695b, this.f66702e.f66696c, (-d.a.c.e.p.l.g(this.f66702e.f66694a, R.dimen.ds430)) + (this.f66702e.f66696c.getMeasuredWidth() / 2) + 30, -g2);
            d.a.c.e.m.e.a().postDelayed(this.f66702e.f66700g, 5000L);
            TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 2));
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f66703e;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66703e = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66703e.h();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f66704e;

        public c(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66704e = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f66704e.i();
                if (this.f66704e.f66697d == null || this.f66704e.f66697d.postTopic == null || this.f66704e.f66697d.getForum() == null) {
                    return;
                }
                if ((this.f66704e.f66698e == null || this.f66704e.f66698e.a()) && !WriteActivityConfig.isAsyncWriting()) {
                    WriteActivityConfig.newInstance(this.f66704e.f66694a).setType(9).setForumData(this.f66704e.f66697d.getForum()).setAntiData(this.f66704e.f66697d.getAnti()).setTitle(this.f66704e.f66697d.postTopic.recom_topic).send();
                    TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 2));
                }
            }
        }
    }

    public l(Activity activity, d.a.s0.u0.m1.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66699f = new a(this);
        this.f66700g = new b(this);
        this.f66701h = new c(this);
        this.f66694a = activity;
        this.f66698e = dVar;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.c.e.m.g.c(this.f66695b);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f66699f);
            d.a.c.e.m.e.a().removeCallbacks(this.f66700g);
            h();
        }
    }

    public void j(View view, FrsViewData frsViewData) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, frsViewData) == null) || view == null || frsViewData == null || frsViewData.postTopic == null || (activity = this.f66694a) == null) {
            return;
        }
        this.f66697d = frsViewData;
        this.f66696c = view;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.frs_tips_blue_twice_line_down, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tips)).setText(StringHelper.cutHotTopicShow(frsViewData.postTopic.recom_title, 24, StringHelper.STRING_MORE));
        ((TextView) inflate.findViewById(R.id.tips_content)).setText(R.string.topic_join);
        inflate.setOnClickListener(this.f66701h);
        this.f66695b = new PopupWindow(inflate, -2, -2);
        d.a.c.e.m.e.a().removeCallbacks(this.f66699f);
        d.a.c.e.m.e.a().postDelayed(this.f66699f, 100L);
    }
}
