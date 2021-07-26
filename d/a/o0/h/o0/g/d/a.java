package d.a.o0.h.o0.g.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter;
import com.baidu.swan.games.view.recommend.listmode.ListRecommendDivider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.g1.f;
import d.a.o0.a.z1.b.b.h;
/* loaded from: classes7.dex */
public class a extends d.a.o0.h.o0.g.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h n;
    public View o;
    public View p;
    public ImageView q;
    public View r;
    public RecyclerView s;
    public ListRecommendAdapter t;

    /* renamed from: d.a.o0.h.o0.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1121a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50731e;

        public View$OnClickListenerC1121a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50731e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f50731e.f50720g != null) {
                    this.f50731e.f50720g.b();
                }
                this.f50731e.B();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ListRecommendAdapter.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f50732a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50732a = aVar;
        }

        @Override // com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f50732a.f50720g != null) {
                    this.f50732a.f50720g.v(i2);
                }
                this.f50732a.y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50733e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50733e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f50733e.f50719f != null && this.f50733e.f50720g != null) {
                    this.f50733e.f50720g.p();
                }
                this.f50733e.y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50734e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50734e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50734e.y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50735e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50735e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f50735e.r.getLayoutParams();
                layoutParams.width = this.f50735e.p.getWidth();
                int height = this.f50735e.p.getHeight();
                layoutParams.height = height;
                layoutParams.topMargin = -height;
                this.f50735e.r.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, @NonNull d.a.o0.h.o0.g.b.d dVar) {
        super(context, dVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (d.a.o0.h.o0.g.b.d) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            view.setOnClickListener(new View$OnClickListenerC1121a(this));
            this.t.f(new b(this));
            this.o.findViewById(d.a.o0.f.e.swangame_recommend_dialog_game_center).setOnClickListener(new c(this));
            this.q.setOnClickListener(new d(this));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C();
            h hVar = this.n;
            if (hVar != null) {
                hVar.show();
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean a2 = d.a.o0.a.c1.a.H().a();
            this.r.setVisibility(8);
            this.q.setImageResource(a2 ? d.a.o0.f.d.swangame_recommend_button_close_night : d.a.o0.f.d.swangame_recommend_button_close);
            if (a2) {
                this.p.post(new e(this));
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SwanAppActivity activity = f.V().getActivity();
            float min = Math.min(activity != null && activity.isLandScape() ? 2.5f : 5.0f, this.s.getAdapter().getItemCount());
            Resources resources = this.f50718e.getResources();
            float dimension = resources.getDimension(d.a.o0.f.c.swangame_recommend_dialog_list_divider_height);
            float dimension2 = resources.getDimension(d.a.o0.f.c.swangame_recommend_dialog_list_default_padding);
            float dimension3 = resources.getDimension(d.a.o0.f.c.swangame_recommend_dialog_width);
            Pair<Integer, Integer> y = f.V().y();
            this.s.getLayoutParams().width = (int) Math.min(dimension3, ((Integer) y.first).intValue());
            this.s.getLayoutParams().height = (int) Math.min((int) ((min * (resources.getDimension(d.a.o0.f.c.swangame_recommend_dialog_list_item_height) + dimension)) + dimension2), ((Integer) y.second).intValue() * 0.67f);
            this.s.requestLayout();
        }
    }

    @Override // d.a.o0.h.o0.g.b.a, d.a.o0.h.o0.g.b.b
    public void d(d.a.o0.h.o0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            super.d(aVar);
            this.t.g(aVar);
            D();
        }
    }

    @Override // d.a.o0.h.o0.g.b.a
    @SuppressLint({"InflateParams"})
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            View i2 = super.i();
            View inflate = LayoutInflater.from(this.f50718e).inflate(d.a.o0.f.f.swangame_recommend_dialog, (ViewGroup) null);
            this.o = inflate;
            this.p = inflate.findViewById(d.a.o0.f.e.swangame_recommend_dialog_content);
            this.r = this.o.findViewById(d.a.o0.f.e.swangame_recommend_dialog_night_mask);
            this.q = (ImageView) this.o.findViewById(d.a.o0.f.e.swangame_recommend_dialog_cancel);
            z();
            RecyclerView recyclerView = (RecyclerView) this.o.findViewById(d.a.o0.f.e.swangame_recommend_dialog_list);
            this.s = recyclerView;
            recyclerView.setItemAnimator(null);
            this.s.setLayoutManager(new LinearLayoutManager(this.f50718e));
            this.s.addItemDecoration(new ListRecommendDivider(this.f50718e));
            ListRecommendAdapter listRecommendAdapter = new ListRecommendAdapter(this.f50718e);
            this.t = listRecommendAdapter;
            this.s.setAdapter(listRecommendAdapter);
            A(i2);
            return i2;
        }
        return (View) invokeV.objValue;
    }

    public final void y() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.dismiss();
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            h.a aVar = new h.a(this.f50718e);
            aVar.m(true);
            aVar.f(true);
            aVar.k(false);
            aVar.j();
            aVar.b();
            aVar.p(17170445);
            aVar.W(this.o);
            aVar.t(false);
            this.n = aVar.c();
            d.a.o0.a.v2.f.b(f.V().getActivity(), this.n);
        }
    }
}
