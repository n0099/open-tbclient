package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d02 {
    public static /* synthetic */ Interceptable $ic;
    public static final FrameLayout.LayoutParams f;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public FrameLayout c;
    public int d;
    public b e;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        public a(d02 d02Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d02Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fa3.c().e(this.a, -1.0f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onCustomViewHidden();
    }

    /* loaded from: classes5.dex */
    public static class c extends FrameLayout {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
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
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755821301, "Lcom/repackage/d02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755821301, "Lcom/repackage/d02;");
                return;
            }
        }
        f = new FrameLayout.LayoutParams(-1, -1);
    }

    public d02(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b == null) {
            return;
        }
        Context context = this.a;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            be3.a0(new a(this, activity));
            b(activity, false);
            ((FrameLayout) activity.getWindow().getDecorView()).removeView(this.c);
            this.c = null;
            this.b = null;
            this.e.onCustomViewHidden();
            activity.setRequestedOrientation(this.d);
        }
    }

    public void b(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, z) == null) {
            activity.getWindow().setFlags(!z ? 0 : 1024, 1024);
        }
    }

    public void c(View view2, int i, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view2, i, bVar) == null) {
            Context context = this.a;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.b != null) {
                    bVar.onCustomViewHidden();
                    return;
                }
                this.d = activity.getRequestedOrientation();
                c cVar = new c(activity);
                this.c = cVar;
                cVar.addView(view2, f);
                ((FrameLayout) activity.getWindow().getDecorView()).addView(this.c, f);
                this.b = view2;
                b(activity, true);
                this.e = bVar;
                activity.setRequestedOrientation(i);
            }
        }
    }
}
