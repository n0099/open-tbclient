package d.a.o0.a.y0.e.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.f;
import d.a.o0.a.g;
import d.a.o0.a.v2.q0;
/* loaded from: classes7.dex */
public class b extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f48938a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f48939b;

    /* renamed from: c  reason: collision with root package name */
    public int f48940c;

    /* renamed from: d  reason: collision with root package name */
    public e f48941d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.a.t0.a f48942e;

    /* loaded from: classes7.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f48943e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48943e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || i2 < 0 || i2 > this.f48943e.f48939b.length) {
                return;
            }
            if (i2 == 11) {
                if (this.f48943e.f48941d != null) {
                    this.f48943e.f48941d.d();
                }
            } else if (this.f48943e.f48941d != null) {
                this.f48943e.f48941d.c(this.f48943e.f48939b[i2]);
            }
        }
    }

    /* renamed from: d.a.o0.a.y0.e.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0987b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GridView f48944e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdapterView.OnItemClickListener f48945f;

        /* renamed from: d.a.o0.a.y0.e.e.b$b$a */
        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RunnableC0987b f48946e;

            public a(RunnableC0987b runnableC0987b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0987b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48946e = runnableC0987b;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    RunnableC0987b runnableC0987b = this.f48946e;
                    runnableC0987b.f48945f.onItemClick(runnableC0987b.f48944e, view, intValue, intValue);
                }
            }
        }

        public RunnableC0987b(b bVar, GridView gridView, AdapterView.OnItemClickListener onItemClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, gridView, onItemClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48944e = gridView;
            this.f48945f = onItemClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int childCount = this.f48944e.getChildCount();
                if (childCount > 0) {
                    this.f48944e.setClickable(false);
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = this.f48944e.getChildAt(i2);
                        childAt.setTag(Integer.valueOf(i2));
                        childAt.setOnClickListener(new a(this));
                    }
                    return;
                }
                this.f48944e.setOnItemClickListener(this.f48945f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f48947e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48947e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48947e.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends d.a.o0.a.t0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f48948a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48948a = bVar;
        }

        @Override // d.a.o0.a.t0.a, d.a.o0.a.t0.b
        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, keyEvent)) == null) {
                if (i2 == 4) {
                    this.f48948a.dismiss();
                    return true;
                }
                return false;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a();

        void b(int i2);

        void c(String str);

        void d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Activity activity, int i2, @NonNull e eVar) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2), eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48939b = new String[12];
        this.f48942e = new d(this);
        this.f48941d = eVar;
        c(i2);
        d(activity);
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int i3 = 0;
            while (i3 < 9) {
                int i4 = i3 + 1;
                this.f48939b[i3] = String.valueOf(i4);
                i3 = i4;
            }
            if (i2 == 1) {
                this.f48939b[9] = "X";
            } else if (i2 == 0) {
                this.f48939b[9] = "";
            } else if (i2 == 2) {
                this.f48939b[9] = ".";
            }
            this.f48939b[10] = "0";
        }
    }

    public final void d(@NonNull Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            this.f48938a = activity;
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(activity).inflate(g.aiapps_keyboard_layout, (ViewGroup) null);
            this.f48940c = activity.getResources().getDimensionPixelOffset(d.a.o0.a.d.aiapps_keyboard_total_height);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            GridView gridView = (GridView) linearLayout.findViewById(f.keyboard_grid_view);
            gridView.setAdapter((ListAdapter) new d.a.o0.a.y0.e.e.a(activity, this.f48939b));
            q0.X(new RunnableC0987b(this, gridView, new a(this)));
            ImageView imageView = (ImageView) linearLayout.findViewById(f.close_btn);
            imageView.setOnClickListener(new c(this));
            imageView.setClickable(true);
            setContentView(linearLayout);
            setWidth(-1);
            setHeight(this.f48940c);
            setBackgroundDrawable(new BitmapDrawable());
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dismiss();
            Activity activity = this.f48938a;
            if (activity instanceof SwanAppActivity) {
                ((SwanAppActivity) activity).unregisterCallback(this.f48942e);
            }
            e eVar = this.f48941d;
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || isShowing()) {
            return;
        }
        showAtLocation(this.f48938a.getWindow().getDecorView(), 80, 0, 0);
        Activity activity = this.f48938a;
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).registerCallback(this.f48942e);
        }
        e eVar = this.f48941d;
        if (eVar != null) {
            eVar.b(this.f48940c);
        }
    }
}
