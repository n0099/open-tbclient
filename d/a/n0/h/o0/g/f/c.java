package d.a.n0.h.o0.g.f;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.f.f;
import d.a.n0.f.h;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class c extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public a f50237e;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    /* loaded from: classes7.dex */
    public static final class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final b f50238e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1712356310, "Ld/a/n0/h/o0/g/f/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1712356310, "Ld/a/n0/h/o0/g/f/c$b;");
                    return;
                }
            }
            f50238e = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View v, MotionEvent event) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, v, event)) == null) {
                Intrinsics.checkNotNullExpressionValue(event, "event");
                int action = event.getAction();
                if (action == 0) {
                    Intrinsics.checkNotNullExpressionValue(v, "v");
                    v.setAlpha(0.2f);
                    return false;
                } else if (action == 1 || action == 3) {
                    Intrinsics.checkNotNullExpressionValue(v, "v");
                    v.setAlpha(1.0f);
                    return false;
                } else {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* renamed from: d.a.n0.h.o0.g.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class View$OnClickListenerC1113c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f50239e;

        public View$OnClickListenerC1113c(c cVar) {
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
            this.f50239e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f50239e.f50237e) == null) {
                return;
            }
            aVar.c();
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f50240e;

        public d(c cVar) {
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
            this.f50240e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f50240e.f50237e) == null) {
                return;
            }
            aVar.b();
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f50241e;

        public e(c cVar) {
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
            this.f50241e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f50241e.f50237e) == null) {
                return;
            }
            aVar.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context, h.SwanGameNoTitleDialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        c();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final View.OnTouchListener b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.f50238e : (View.OnTouchListener) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(f.aiapps_pandapark_close_dialog);
            setCanceledOnTouchOutside(false);
            d();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ((Button) findViewById(d.a.n0.f.e.exit_button)).setOnTouchListener(b());
            ((Button) findViewById(d.a.n0.f.e.exit_button)).setOnClickListener(new View$OnClickListenerC1113c(this));
            ((ImageView) findViewById(d.a.n0.f.e.image_close)).setOnTouchListener(b());
            ((ImageView) findViewById(d.a.n0.f.e.image_close)).setOnClickListener(new d(this));
            ((Button) findViewById(d.a.n0.f.e.continue_button)).setOnTouchListener(b());
            ((Button) findViewById(d.a.n0.f.e.continue_button)).setOnClickListener(new e(this));
        }
    }

    public final void e(a onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
            this.f50237e = onClickListener;
        }
    }
}
