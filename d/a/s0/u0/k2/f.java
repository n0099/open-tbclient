package d.a.s0.u0.k2;

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
import d.a.c.e.p.l;
import d.a.s0.u0.e1;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f66236a;

    /* renamed from: b  reason: collision with root package name */
    public e1 f66237b;

    /* renamed from: c  reason: collision with root package name */
    public MorePopupWindow f66238c;

    /* renamed from: d  reason: collision with root package name */
    public View f66239d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<d.a.s0.u0.k2.b> f66240e;

    /* renamed from: f  reason: collision with root package name */
    public Context f66241f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.u0.k2.b f66242g;

    /* renamed from: h  reason: collision with root package name */
    public e f66243h;

    /* renamed from: i  reason: collision with root package name */
    public d f66244i;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f66245e;

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
            this.f66245e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.c.e.m.g.c(this.f66245e.f66238c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements KeyEventDealContainerView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f66246a;

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
            this.f66246a = fVar;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f66246a.f66238c == null) {
                return;
            }
            d.a.c.e.m.g.c(this.f66246a.f66238c);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TabItemView f66247e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f66248f;

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
            this.f66248f = fVar;
            this.f66247e = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f66248f.f66244i == null) {
                return;
            }
            this.f66248f.f66244i.a(this.f66247e);
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a(int i2);
    }

    /* renamed from: d.a.s0.u0.k2.f$f  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1724f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f66249a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f66250b;

        /* renamed from: c  reason: collision with root package name */
        public View f66251c;

        /* renamed from: d  reason: collision with root package name */
        public View f66252d;

        public C1724f() {
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
        this.f66241f = context;
        this.f66243h = eVar;
        this.f66244i = dVar;
        this.f66240e = new SparseArray<>();
        LinearLayout linearLayout = new LinearLayout(context);
        this.f66236a = linearLayout;
        linearLayout.setOrientation(1);
        this.f66236a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view = new View(context);
        this.f66239d = view;
        view.setOnClickListener(new a(this));
    }

    public void c() {
        MorePopupWindow morePopupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (morePopupWindow = this.f66238c) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66243h : (e) invokeV.objValue;
    }

    public final void e(Activity activity, View view, TabItemView tabItemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, view, tabItemView) == null) {
            if (this.f66238c == null) {
                this.f66238c = new MorePopupWindow(activity, this.f66236a, view, SkinManager.getDrawable(R.drawable.transparent_bg), new b(this));
            }
            this.f66238c.setOnDismissListener(new c(this, tabItemView));
        }
    }

    public void f(Activity activity, View view, TabItemView tabItemView, e1 e1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, view, tabItemView, e1Var) == null) {
            this.f66237b = e1Var;
            d.a.s0.u0.k2.b bVar = this.f66240e.get(e1Var.f65836a);
            this.f66242g = bVar;
            if (bVar == null) {
                d.a.s0.u0.k2.b a2 = i.a(this.f66237b.f65836a);
                this.f66242g = a2;
                a2.a(this.f66241f, this);
                this.f66240e.put(this.f66237b.f65836a, this.f66242g);
            }
            this.f66242g.setData(e1Var.f65837b);
            if (view instanceof HorizontalTabView) {
                HorizontalTabView horizontalTabView = (HorizontalTabView) view;
                if (horizontalTabView.getmShowMenuCallBack() != null) {
                    int[] iArr = new int[2];
                    horizontalTabView.getLocationInWindow(iArr);
                    l.y(horizontalTabView.getContext());
                    int i2 = l.i(horizontalTabView.getContext());
                    int b2 = this.f66242g.b();
                    int measuredHeight = (i2 - iArr[1]) - horizontalTabView.getMeasuredHeight();
                    if (measuredHeight < b2) {
                        horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                    }
                }
            }
            this.f66236a.removeAllViews();
            this.f66236a.addView(this.f66242g.getView());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            SkinManager.setBackgroundResource(this.f66239d, R.color.common_color_10050);
            this.f66236a.addView(this.f66239d, layoutParams);
            e(activity, view, tabItemView);
            MorePopupWindow morePopupWindow = this.f66238c;
            if (morePopupWindow != null) {
                morePopupWindow.refresh();
                this.f66238c.setWidthAsWidthOfDeviceScreen(activity);
                this.f66238c.setHeight(-1);
                this.f66238c.showWindowInCustomPosition(0, 0);
            }
        }
    }
}
