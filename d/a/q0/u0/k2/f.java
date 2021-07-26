package d.a.q0.u0.k2;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.u0.e1;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f63660a;

    /* renamed from: b  reason: collision with root package name */
    public e1 f63661b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f63662c;

    /* renamed from: d  reason: collision with root package name */
    public View f63663d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<d.a.q0.u0.k2.b> f63664e;

    /* renamed from: f  reason: collision with root package name */
    public Context f63665f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.u0.k2.b f63666g;

    /* renamed from: h  reason: collision with root package name */
    public e f63667h;

    /* renamed from: i  reason: collision with root package name */
    public d f63668i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f63669e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63669e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.d.e.m.g.c(this.f63669e.f63662c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements KeyEventDealContainerView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f63670a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63670a = fVar;
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f63670a.f63662c == null) {
                return;
            }
            d.a.d.e.m.g.c(this.f63670a.f63662c);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f63671e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f63672f;

        public c(f fVar, TabItemView tabItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, tabItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63672f = fVar;
            this.f63671e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f63672f.f63668i == null) {
                return;
            }
            this.f63672f.f63668i.a(this.f63671e);
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(int i2);
    }

    /* renamed from: d.a.q0.u0.k2.f$f  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1685f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f63673a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f63674b;

        /* renamed from: c  reason: collision with root package name */
        public View f63675c;

        /* renamed from: d  reason: collision with root package name */
        public View f63676d;

        public C1685f() {
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
    }

    public f(Context context, e eVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, eVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63665f = context;
        this.f63667h = eVar;
        this.f63668i = dVar;
        this.f63664e = new SparseArray<>();
        LinearLayout linearLayout = new LinearLayout(context);
        this.f63660a = linearLayout;
        linearLayout.setOrientation(1);
        this.f63660a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f63663d = view;
        view.setOnClickListener(new a(this));
    }

    public void c() {
        MorePopupWindow morePopupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (morePopupWindow = this.f63662c) == null) {
            return;
        }
        try {
            morePopupWindow.dismiss();
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63667h : (e) invokeV.objValue;
    }

    public final void e(Activity activity, View view, TabItemView tabItemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, view, tabItemView) == null) {
            if (this.f63662c == null) {
                this.f63662c = new MorePopupWindow(activity, this.f63660a, view, SkinManager.getDrawable(R.drawable.transparent_bg), new b(this));
            }
            this.f63662c.setOnDismissListener(new c(this, tabItemView));
        }
    }

    public void f(Activity activity, View view, TabItemView tabItemView, e1 e1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, view, tabItemView, e1Var) == null) {
            this.f63661b = e1Var;
            d.a.q0.u0.k2.b bVar = this.f63664e.get(e1Var.f63260a);
            this.f63666g = bVar;
            if (bVar == null) {
                d.a.q0.u0.k2.b a2 = i.a(this.f63661b.f63260a);
                this.f63666g = a2;
                a2.a(this.f63665f, this);
                this.f63664e.put(this.f63661b.f63260a, this.f63666g);
            }
            this.f63666g.setData(e1Var.f63261b);
            if (view instanceof HorizontalTabView) {
                HorizontalTabView horizontalTabView = (HorizontalTabView) view;
                if (horizontalTabView.getmShowMenuCallBack() != null) {
                    int[] iArr = new int[2];
                    horizontalTabView.getLocationInWindow(iArr);
                    l.y(horizontalTabView.getContext());
                    int i2 = l.i(horizontalTabView.getContext());
                    int b2 = this.f63666g.b();
                    int measuredHeight = (i2 - iArr[1]) - horizontalTabView.getMeasuredHeight();
                    if (measuredHeight < b2) {
                        horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                    }
                }
            }
            this.f63660a.removeAllViews();
            this.f63660a.addView(this.f63666g.getView());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            SkinManager.setBackgroundResource(this.f63663d, R.color.common_color_10050);
            this.f63660a.addView(this.f63663d, layoutParams);
            e(activity, view, tabItemView);
            MorePopupWindow morePopupWindow = this.f63662c;
            if (morePopupWindow != null) {
                morePopupWindow.refresh();
                this.f63662c.setWidthAsWidthOfDeviceScreen(activity);
                this.f63662c.setHeight(-1);
                this.f63662c.showWindowInCustomPosition(0, 0);
            }
        }
    }
}
