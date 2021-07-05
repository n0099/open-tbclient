package d.a.q0.a.p2;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f50041a;

    /* renamed from: b  reason: collision with root package name */
    public int f50042b;

    /* renamed from: c  reason: collision with root package name */
    public View f50043c;

    /* renamed from: d  reason: collision with root package name */
    public int f50044d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.a.p2.a f50045e;

    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50046e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f50047f;

        public a(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50047f = bVar;
            this.f50046e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f50047f.f50045e != null) {
                    this.f50047f.f50045e.c(this.f50046e);
                }
                Rect rect = new Rect();
                this.f50047f.f50043c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f50047f.f50044d == this.f50047f.f50041a) {
                    this.f50047f.f50044d = height;
                } else if (this.f50047f.f50044d == height) {
                } else {
                    if (this.f50047f.f50044d - height > this.f50047f.f50042b) {
                        if (this.f50047f.f50045e != null) {
                            this.f50047f.f50045e.b(this.f50046e, this.f50047f.f50044d - height);
                        }
                        this.f50047f.f50044d = height;
                    } else if (height - this.f50047f.f50044d > this.f50047f.f50042b) {
                        if (this.f50047f.f50045e != null) {
                            this.f50047f.f50045e.a(this.f50046e, height - this.f50047f.f50044d);
                        }
                        this.f50047f.f50044d = height;
                    }
                }
            }
        }
    }

    public b(String str, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50041a = 0;
        this.f50042b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.f50043c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
    }

    public static void g(String str, Activity activity, d.a.q0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, activity, aVar) == null) {
            new b(str, activity).h(aVar);
        }
    }

    public final void h(d.a.q0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f50045e = aVar;
        }
    }
}
