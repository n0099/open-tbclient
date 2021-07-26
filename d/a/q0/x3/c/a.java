package d.a.q0.x3.c;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.g.d;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f66920a;

    /* renamed from: b  reason: collision with root package name */
    public String f66921b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.d.e.g.c f66922c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f66923d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.d.e.g.b f66924e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f66925f;

    /* renamed from: g  reason: collision with root package name */
    public final Activity f66926g;

    /* renamed from: h  reason: collision with root package name */
    public final ViewGroup f66927h;

    /* renamed from: d.a.q0.x3.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1849a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66928e;

        public RunnableC1849a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66928e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f66928e.f66922c == null) {
                return;
            }
            this.f66928e.f66922c.e(this.f66928e.f66927h);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66929a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66929a = aVar;
        }

        @Override // d.a.d.e.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66929a.f66922c = null;
                this.f66929a.f66925f.removeCallbacks(this.f66929a.f66923d);
            }
        }

        @Override // d.a.d.e.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.d.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66930a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66930a = aVar;
        }

        @Override // d.a.d.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = LayoutInflater.from(this.f66930a.f66926g).inflate(R.layout.warning_toast, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.toast_title);
                TextView textView2 = (TextView) inflate.findViewById(R.id.toast_tip);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0101);
                ((ImageView) inflate.findViewById(R.id.toast_img)).setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_toast_mistake_40, SkinManager.getColor(R.color.CAM_X0101), null));
                textView.setText(this.f66930a.f66920a);
                if (!StringUtils.isNull(this.f66930a.f66921b)) {
                    textView2.setText(this.f66930a.f66921b);
                } else {
                    textView2.setVisibility(8);
                }
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // d.a.d.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // d.a.d.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    public a(Activity activity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66925f = new Handler();
        this.f66926g = activity;
        this.f66927h = viewGroup;
    }

    public final d.a.d.e.g.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this) : (d.a.d.e.g.b) invokeV.objValue;
    }

    public void j() {
        d.a.d.e.g.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.f66922c) == null) {
            return;
        }
        cVar.e(this.f66927h);
        this.f66927h.setVisibility(8);
    }

    public a k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f66920a = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public void l() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (viewGroup = this.f66927h) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        d.a.d.e.g.c cVar = this.f66922c;
        if (cVar != null) {
            cVar.e(this.f66927h);
        }
        this.f66923d = new RunnableC1849a(this);
        d.a.d.e.g.d dVar = new d.a.d.e.g.d();
        dVar.d(true);
        dVar.g(new b(this));
        if (this.f66924e == null) {
            this.f66924e = i();
        }
        dVar.a(this.f66924e);
        d.a.d.e.g.c b2 = dVar.b();
        this.f66922c = b2;
        b2.q(this.f66926g, this.f66927h, false);
        this.f66925f.postDelayed(this.f66923d, 3000L);
    }
}
