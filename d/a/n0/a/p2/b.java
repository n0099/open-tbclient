package d.a.n0.a.p2;

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
    public int f46739a;

    /* renamed from: b  reason: collision with root package name */
    public int f46740b;

    /* renamed from: c  reason: collision with root package name */
    public View f46741c;

    /* renamed from: d  reason: collision with root package name */
    public int f46742d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.a.p2.a f46743e;

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46744e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f46745f;

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
            this.f46745f = bVar;
            this.f46744e = str;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f46745f.f46743e != null) {
                    this.f46745f.f46743e.c(this.f46744e);
                }
                Rect rect = new Rect();
                this.f46745f.f46741c.getWindowVisibleDisplayFrame(rect);
                int height = rect.height();
                if (this.f46745f.f46742d == this.f46745f.f46739a) {
                    this.f46745f.f46742d = height;
                } else if (this.f46745f.f46742d == height) {
                } else {
                    if (this.f46745f.f46742d - height > this.f46745f.f46740b) {
                        if (this.f46745f.f46743e != null) {
                            this.f46745f.f46743e.b(this.f46744e, this.f46745f.f46742d - height);
                        }
                        this.f46745f.f46742d = height;
                    } else if (height - this.f46745f.f46742d > this.f46745f.f46740b) {
                        if (this.f46745f.f46743e != null) {
                            this.f46745f.f46743e.a(this.f46744e, height - this.f46745f.f46742d);
                        }
                        this.f46745f.f46742d = height;
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
        this.f46739a = 0;
        this.f46740b = 200;
        View decorView = activity.getWindow().getDecorView();
        this.f46741c = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, str));
    }

    public static void g(String str, Activity activity, d.a.n0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, activity, aVar) == null) {
            new b(str, activity).h(aVar);
        }
    }

    public final void h(d.a.n0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f46743e = aVar;
        }
    }
}
