package d.a.p0.l0.h;

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
import d.a.p0.l0.d.h;
import d.a.p0.l0.m.a;
import d.a.p0.l0.m.f;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f59609a;

    /* renamed from: b  reason: collision with root package name */
    public int f59610b;

    /* renamed from: c  reason: collision with root package name */
    public int f59611c;

    /* renamed from: d  reason: collision with root package name */
    public Context f59612d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.l0.m.a f59613e;

    /* renamed from: f  reason: collision with root package name */
    public d f59614f;

    /* renamed from: g  reason: collision with root package name */
    public f f59615g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59616h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f59617i;
    public View.OnClickListener j;
    public PopupWindow.OnDismissListener k;

    /* loaded from: classes8.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f59618a;

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
            this.f59618a = bVar;
        }

        @Override // d.a.p0.l0.m.a.d
        public void onItemClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f59618a.f59611c = i2;
                TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i2 == 1 ? 2 : 1));
                this.f59618a.r();
                if (this.f59618a.f59614f != null) {
                    this.f59618a.f59614f.a(this.f59618a.f59611c);
                }
            }
        }
    }

    /* renamed from: d.a.p0.l0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1520b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59619e;

        public View$OnClickListenerC1520b(b bVar) {
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
            this.f59619e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f59619e.f59615g.r()) {
                return;
            }
            if (view == this.f59619e.f59609a) {
                if (this.f59619e.f59613e == null) {
                    this.f59619e.f59613e = new d.a.p0.l0.m.a(this.f59619e.f59612d);
                    this.f59619e.f59613e.setOnDismissListener(this.f59619e.k);
                    this.f59619e.f59613e.l(this.f59619e.f59617i);
                    this.f59619e.f59613e.m(this.f59619e.f59610b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(this.f59619e.f59612d.getString(R.string.level_sort), 1));
                arrayList.add(new h(this.f59619e.f59612d.getString(R.string.update_sort), 2));
                this.f59619e.f59613e.k(arrayList, this.f59619e.f59611c);
                this.f59619e.f59613e.o(this.f59619e.f59609a);
            }
            this.f59619e.f59616h = true;
            b bVar = this.f59619e;
            bVar.s(bVar.f59616h);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f59620e;

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
            this.f59620e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59620e.f59616h = false;
                b bVar = this.f59620e;
                bVar.s(bVar.f59616h);
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
        this.f59616h = false;
        this.f59617i = new a(this);
        this.j = new View$OnClickListenerC1520b(this);
        this.k = new c(this);
        this.f59612d = context;
        this.f59611c = i2;
        this.f59610b = i3;
        this.f59615g = fVar;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f59611c;
            return i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        d.a.p0.l0.m.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f59613e) == null) {
            return;
        }
        aVar.i();
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (o()) {
                SkinManager.setViewTextColor(this.f59609a, R.color.CAM_X0105, i2);
                if (this.f59609a != null) {
                    s(this.f59616h);
                }
            }
            d.a.p0.l0.m.a aVar = this.f59613e;
            if (aVar == null || !this.f59616h) {
                return;
            }
            aVar.j();
        }
    }

    public void r() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && o() && (textView = this.f59609a) != null) {
            int i2 = this.f59611c;
            if (i2 == 1) {
                textView.setText(R.string.level_sort);
            } else if (i2 == 2) {
                textView.setText(R.string.update_sort);
            }
            this.f59609a.setOnClickListener(this.j);
            s(this.f59616h);
        }
    }

    public final void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            int i2 = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
            f fVar = this.f59615g;
            d.a.p0.l0.d.c n = fVar != null ? fVar.n() : null;
            if (n != null && n.f59543a) {
                f fVar2 = this.f59615g;
                if (fVar2 != null && fVar2.t()) {
                    SkinManager.setViewTextColor(this.f59609a, R.color.CAM_X0107);
                    this.f59609a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                    return;
                }
                SkinManager.setViewTextColor(this.f59609a, R.color.CAM_X0107);
                this.f59609a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.f59609a, R.color.CAM_X0107);
            this.f59609a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && o()) {
            this.f59611c = i2;
            r();
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f59614f = dVar;
        }
    }

    public void v(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, textView) == null) {
            this.f59609a = textView;
        }
    }
}
