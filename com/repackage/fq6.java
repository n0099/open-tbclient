package com.repackage;

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
/* loaded from: classes6.dex */
public class fq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public qg6 b;
    public MorePopupWindow c;
    public View d;
    public SparseArray<bq6> e;
    public Context f;
    public bq6 g;
    public e h;
    public d i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fq6 a;

        public a(fq6 fq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fq6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                tg.c(this.a.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements KeyEventDealContainerView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fq6 a;

        public b(fq6 fq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fq6Var;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.c == null) {
                return;
            }
            tg.c(this.a.c);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TabItemView a;
        public final /* synthetic */ fq6 b;

        public c(fq6 fq6Var, TabItemView tabItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq6Var, tabItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fq6Var;
            this.a = tabItemView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.i == null) {
                return;
            }
            this.b.i.a(this.a);
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(int i);
    }

    /* loaded from: classes6.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ImageView b;
        public View c;
        public View d;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public fq6(Context context, e eVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, eVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = context;
        this.h = eVar;
        this.i = dVar;
        this.e = new SparseArray<>();
        LinearLayout linearLayout = new LinearLayout(context);
        this.a = linearLayout;
        linearLayout.setOrientation(1);
        this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        View view2 = new View(context);
        this.d = view2;
        view2.setOnClickListener(new a(this));
    }

    public void c() {
        MorePopupWindow morePopupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (morePopupWindow = this.c) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (e) invokeV.objValue;
    }

    public final void e(Activity activity, View view2, TabItemView tabItemView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, view2, tabItemView) == null) {
            if (this.c == null) {
                this.c = new MorePopupWindow(activity, this.a, view2, SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f081210), new b(this));
            }
            this.c.setOnDismissListener(new c(this, tabItemView));
        }
    }

    public void f(Activity activity, View view2, TabItemView tabItemView, qg6 qg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, view2, tabItemView, qg6Var) == null) {
            this.b = qg6Var;
            bq6 bq6Var = this.e.get(qg6Var.a);
            this.g = bq6Var;
            if (bq6Var == null) {
                bq6 a2 = iq6.a(this.b.a);
                this.g = a2;
                a2.a(this.f, this);
                this.e.put(this.b.a, this.g);
            }
            this.g.setData(qg6Var.b);
            if (view2 instanceof HorizontalTabView) {
                HorizontalTabView horizontalTabView = (HorizontalTabView) view2;
                if (horizontalTabView.getmShowMenuCallBack() != null) {
                    int[] iArr = new int[2];
                    horizontalTabView.getLocationInWindow(iArr);
                    qi.y(horizontalTabView.getContext());
                    int i = qi.i(horizontalTabView.getContext());
                    int b2 = this.g.b();
                    int measuredHeight = (i - iArr[1]) - horizontalTabView.getMeasuredHeight();
                    if (measuredHeight < b2) {
                        horizontalTabView.getmShowMenuCallBack().b(b2 - measuredHeight);
                    }
                }
            }
            this.a.removeAllViews();
            this.a.addView(this.g.getView());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            SkinManager.setBackgroundResource(this.d, R.color.common_color_10050);
            this.a.addView(this.d, layoutParams);
            e(activity, view2, tabItemView);
            MorePopupWindow morePopupWindow = this.c;
            if (morePopupWindow != null) {
                morePopupWindow.refresh();
                this.c.setWidthAsWidthOfDeviceScreen(activity);
                this.c.setHeight(-1);
                this.c.showWindowInCustomPosition(0, 0);
            }
        }
    }
}
