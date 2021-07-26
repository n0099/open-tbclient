package d.a.o0.a.p2;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f47243a;

    /* renamed from: b  reason: collision with root package name */
    public int f47244b;

    /* renamed from: c  reason: collision with root package name */
    public View f47245c;

    /* renamed from: d  reason: collision with root package name */
    public int f47246d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.a.p2.a f47247e;

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47248e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f47249f;

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
            this.f47249f = bVar;
            this.f47248e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f47249f.f47247e != null) {
                    this.f47249f.f47247e.c(this.f47248e);
                }
                Rect rect = new Rect();
                this.f47249f.f47245c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f47249f.f47246d == this.f47249f.f47243a) {
                    this.f47249f.f47246d = height;
                } else if (this.f47249f.f47246d == height) {
                } else {
                    if (this.f47249f.f47246d - height > this.f47249f.f47244b) {
                        if (this.f47249f.f47247e != null) {
                            this.f47249f.f47247e.b(this.f47248e, this.f47249f.f47246d - height);
                        }
                        this.f47249f.f47246d = height;
                    } else if (height - this.f47249f.f47246d > this.f47249f.f47244b) {
                        if (this.f47249f.f47247e != null) {
                            this.f47249f.f47247e.a(this.f47248e, height - this.f47249f.f47246d);
                        }
                        this.f47249f.f47246d = height;
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
        this.f47243a = 0;
        this.f47244b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.f47245c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
    }

    public static void g(String str, Activity activity, d.a.o0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, activity, aVar) == null) {
            new b(str, activity).h(aVar);
        }
    }

    public final void h(d.a.o0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f47247e = aVar;
        }
    }
}
