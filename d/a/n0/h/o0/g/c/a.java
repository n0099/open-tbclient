package d.a.n0.h.o0.g.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.f.g;
import d.a.n0.h.o0.g.b.d;
/* loaded from: classes7.dex */
public class a extends d.a.n0.h.o0.g.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int n;
    public d.a.n0.h.o0.g.c.b o;
    public d.a.n0.h.o0.g.c.b p;

    /* renamed from: d.a.n0.h.o0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1111a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50222e;

        public View$OnClickListenerC1111a(a aVar) {
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
            this.f50222e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50222e.f50216g == null || this.f50222e.n < -1) {
                return;
            }
            if (this.f50222e.n == -1) {
                this.f50222e.f50216g.p();
            } else {
                this.f50222e.f50216g.v(this.f50222e.n);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50223e;

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
            this.f50223e = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                a aVar = this.f50223e;
                RecommendItemModel y = aVar.y(aVar.n);
                this.f50223e.o.f50225b.setImageURI(y.iconUrl);
                this.f50223e.o.f50226c.setText(y.appName);
                this.f50223e.o.f50224a.setAlpha(1.0f);
                a aVar2 = this.f50223e;
                RecommendItemModel y2 = this.f50223e.y(aVar2.x(aVar2.n));
                this.f50223e.p.f50225b.setImageURI(y2.iconUrl);
                this.f50223e.p.f50226c.setText(y2.appName);
                this.f50223e.p.f50224a.setAlpha(0.0f);
                a.super.k();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context, @NonNull d dVar) {
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
                super((Context) objArr2[0], (d) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = -2;
    }

    @Override // d.a.n0.h.o0.g.b.a, d.a.n0.h.o0.g.b.b
    public void d(d.a.n0.h.o0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.d(aVar);
            if (z(aVar)) {
                return;
            }
            this.n = -2;
            this.p.f50225b.setImageURI(aVar.f50232a.iconUrl);
            this.p.f50226c.setText(aVar.f50232a.appName);
        }
    }

    @Override // d.a.n0.h.o0.g.b.a
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.f50214e);
            d.a.n0.h.o0.g.c.b bVar = new d.a.n0.h.o0.g.c.b(this.f50214e);
            this.p = bVar;
            bVar.f50224a.setAlpha(0.0f);
            frameLayout.addView(this.p.f50224a);
            d.a.n0.h.o0.g.c.b bVar2 = new d.a.n0.h.o0.g.c.b(this.f50214e);
            this.o = bVar2;
            bVar2.f50224a.setAlpha(0.0f);
            this.o.f50225b.setActualImageResource(17170445);
            this.o.f50226c.setText((CharSequence) null);
            frameLayout.addView(this.o.f50224a);
            this.o.f50224a.setOnClickListener(new View$OnClickListenerC1111a(this));
            return frameLayout;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.n0.h.o0.g.b.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (z(this.f50215f)) {
                this.o.f50224a.setAlpha(1.0f);
                this.o.f50225b.setActualImageResource(d.a.n0.f.d.swangame_recommend_gamecenter);
                this.o.f50226c.setText(g.swangame_recommend_button_goto_game_center);
                super.k();
                return;
            }
            this.n = x(this.n);
            this.p.f50224a.animate().setDuration(160L).alpha(1.0f);
            this.o.f50224a.animate().setDuration(160L).alpha(0.0f).setListener(new b(this));
        }
    }

    public final int x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int i3 = i2 + 1;
            if (i3 == this.f50215f.f50233b.size()) {
                return -1;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public final RecommendItemModel y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 == -1 ? this.f50215f.f50232a : this.f50215f.f50233b.get(i2) : (RecommendItemModel) invokeI.objValue;
    }

    public final boolean z(d.a.n0.h.o0.g.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) ? aVar == null || aVar.f50233b == null || aVar.f50232a == null : invokeL.booleanValue;
    }
}
