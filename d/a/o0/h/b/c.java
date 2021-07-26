package d.a.o0.h.b;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.q0;
import d.a.o0.a.z1.b.b.h;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f50255a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f50256e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50257f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50258g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f50259h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f50260i;
        public final /* synthetic */ c j;

        public a(c cVar, Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, activity, str, str2, Boolean.valueOf(z), onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = cVar;
            this.f50256e = activity;
            this.f50257f = str;
            this.f50258g = str2;
            this.f50259h = z;
            this.f50260i = onClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.j.f50255a != null && this.j.f50255a.isShowing()) {
                    this.j.f50255a.dismiss();
                }
                Activity activity = this.f50256e;
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                h.a d2 = this.j.d(this.f50256e, this.f50257f, this.f50258g, this.f50259h, this.f50260i);
                this.j.f50255a = d2.X();
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final h.a d(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{activity, str, str2, Boolean.valueOf(z), onClickListener})) == null) {
            h.a aVar = new h.a(activity);
            aVar.x(str);
            aVar.a();
            aVar.n(new d.a.o0.a.w2.h.a());
            aVar.m(z);
            aVar.Q(d.a.o0.f.b.swan_games_antiaddiction_positive);
            aVar.f(true);
            aVar.P(str2, onClickListener);
            return aVar;
        }
        return (h.a) invokeCommon.objValue;
    }

    public void e() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (hVar = this.f50255a) == null) {
            return;
        }
        if (hVar.isShowing()) {
            this.f50255a.dismiss();
        }
        this.f50255a = null;
    }

    public void f(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, str, str2, Boolean.valueOf(z), onClickListener}) == null) {
            q0.X(new a(this, activity, str, str2, z, onClickListener));
        }
    }
}
