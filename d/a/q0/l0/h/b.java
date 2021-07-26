package d.a.q0.l0.h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.l0.d.h;
import d.a.q0.l0.m.a;
import d.a.q0.l0.m.f;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f60223a;

    /* renamed from: b  reason: collision with root package name */
    public int f60224b;

    /* renamed from: c  reason: collision with root package name */
    public int f60225c;

    /* renamed from: d  reason: collision with root package name */
    public Context f60226d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.l0.m.a f60227e;

    /* renamed from: f  reason: collision with root package name */
    public d f60228f;

    /* renamed from: g  reason: collision with root package name */
    public f f60229g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60230h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f60231i;
    public View.OnClickListener j;
    public PopupWindow.OnDismissListener k;

    /* loaded from: classes8.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60232a;

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
            this.f60232a = bVar;
        }

        @Override // d.a.q0.l0.m.a.d
        public void onItemClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f60232a.f60225c = i2;
                TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i2 == 1 ? 2 : 1));
                this.f60232a.r();
                if (this.f60232a.f60228f != null) {
                    this.f60232a.f60228f.a(this.f60232a.f60225c);
                }
            }
        }
    }

    /* renamed from: d.a.q0.l0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1525b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60233e;

        public View$OnClickListenerC1525b(b bVar) {
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
            this.f60233e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f60233e.f60229g.r()) {
                return;
            }
            if (view == this.f60233e.f60223a) {
                if (this.f60233e.f60227e == null) {
                    this.f60233e.f60227e = new d.a.q0.l0.m.a(this.f60233e.f60226d);
                    this.f60233e.f60227e.setOnDismissListener(this.f60233e.k);
                    this.f60233e.f60227e.l(this.f60233e.f60231i);
                    this.f60233e.f60227e.m(this.f60233e.f60224b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(this.f60233e.f60226d.getString(R.string.level_sort), 1));
                arrayList.add(new h(this.f60233e.f60226d.getString(R.string.update_sort), 2));
                this.f60233e.f60227e.k(arrayList, this.f60233e.f60225c);
                this.f60233e.f60227e.o(this.f60233e.f60223a);
            }
            this.f60233e.f60230h = true;
            b bVar = this.f60233e;
            bVar.s(bVar.f60230h);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f60234e;

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
            this.f60234e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60234e.f60230h = false;
                b bVar = this.f60234e;
                bVar.s(bVar.f60230h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(int i2);
    }

    public b(Context context, int i2, int i3, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60230h = false;
        this.f60231i = new a(this);
        this.j = new View$OnClickListenerC1525b(this);
        this.k = new c(this);
        this.f60226d = context;
        this.f60225c = i2;
        this.f60224b = i3;
        this.f60229g = fVar;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f60225c;
            return i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        d.a.q0.l0.m.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f60227e) == null) {
            return;
        }
        aVar.i();
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (o()) {
                SkinManager.setViewTextColor(this.f60223a, R.color.CAM_X0105, i2);
                if (this.f60223a != null) {
                    s(this.f60230h);
                }
            }
            d.a.q0.l0.m.a aVar = this.f60227e;
            if (aVar == null || !this.f60230h) {
                return;
            }
            aVar.j();
        }
    }

    public void r() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && o() && (textView = this.f60223a) != null) {
            int i2 = this.f60225c;
            if (i2 == 1) {
                textView.setText(R.string.level_sort);
            } else if (i2 == 2) {
                textView.setText(R.string.update_sort);
            }
            this.f60223a.setOnClickListener(this.j);
            s(this.f60230h);
        }
    }

    public final void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            int i2 = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
            f fVar = this.f60229g;
            d.a.q0.l0.d.c n = fVar != null ? fVar.n() : null;
            if (n != null && n.f60157a) {
                f fVar2 = this.f60229g;
                if (fVar2 != null && fVar2.t()) {
                    SkinManager.setViewTextColor(this.f60223a, R.color.CAM_X0107);
                    this.f60223a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                    return;
                }
                SkinManager.setViewTextColor(this.f60223a, R.color.CAM_X0107);
                this.f60223a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.f60223a, R.color.CAM_X0107);
            this.f60223a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && o()) {
            this.f60225c = i2;
            r();
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f60228f = dVar;
        }
    }

    public void v(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, textView) == null) {
            this.f60223a = textView;
        }
    }
}
