package d.a.s0.l0.h;

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
import d.a.s0.l0.d.h;
import d.a.s0.l0.m.a;
import d.a.s0.l0.m.f;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f62846a;

    /* renamed from: b  reason: collision with root package name */
    public int f62847b;

    /* renamed from: c  reason: collision with root package name */
    public int f62848c;

    /* renamed from: d  reason: collision with root package name */
    public Context f62849d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.l0.m.a f62850e;

    /* renamed from: f  reason: collision with root package name */
    public d f62851f;

    /* renamed from: g  reason: collision with root package name */
    public f f62852g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62853h;

    /* renamed from: i  reason: collision with root package name */
    public a.d f62854i;
    public View.OnClickListener j;
    public PopupWindow.OnDismissListener k;

    /* loaded from: classes9.dex */
    public class a implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62855a;

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
            this.f62855a = bVar;
        }

        @Override // d.a.s0.l0.m.a.d
        public void onItemClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f62855a.f62848c = i2;
                TiebaStatic.log(new StatisticItem("c13369").param("obj_type", i2 == 1 ? 2 : 1));
                this.f62855a.r();
                if (this.f62855a.f62851f != null) {
                    this.f62855a.f62851f.a(this.f62855a.f62848c);
                }
            }
        }
    }

    /* renamed from: d.a.s0.l0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1564b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f62856e;

        public View$OnClickListenerC1564b(b bVar) {
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
            this.f62856e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f62856e.f62852g.r()) {
                return;
            }
            if (view == this.f62856e.f62846a) {
                if (this.f62856e.f62850e == null) {
                    this.f62856e.f62850e = new d.a.s0.l0.m.a(this.f62856e.f62849d);
                    this.f62856e.f62850e.setOnDismissListener(this.f62856e.k);
                    this.f62856e.f62850e.l(this.f62856e.f62854i);
                    this.f62856e.f62850e.m(this.f62856e.f62847b);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new h(this.f62856e.f62849d.getString(R.string.level_sort), 1));
                arrayList.add(new h(this.f62856e.f62849d.getString(R.string.update_sort), 2));
                this.f62856e.f62850e.k(arrayList, this.f62856e.f62848c);
                this.f62856e.f62850e.o(this.f62856e.f62846a);
            }
            this.f62856e.f62853h = true;
            b bVar = this.f62856e;
            bVar.s(bVar.f62853h);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f62857e;

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
            this.f62857e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f62857e.f62853h = false;
                b bVar = this.f62857e;
                bVar.s(bVar.f62853h);
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f62853h = false;
        this.f62854i = new a(this);
        this.j = new View$OnClickListenerC1564b(this);
        this.k = new c(this);
        this.f62849d = context;
        this.f62848c = i2;
        this.f62847b = i3;
        this.f62852g = fVar;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f62848c;
            return i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        d.a.s0.l0.m.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f62850e) == null) {
            return;
        }
        aVar.i();
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (o()) {
                SkinManager.setViewTextColor(this.f62846a, R.color.CAM_X0105, i2);
                if (this.f62846a != null) {
                    s(this.f62853h);
                }
            }
            d.a.s0.l0.m.a aVar = this.f62850e;
            if (aVar == null || !this.f62853h) {
                return;
            }
            aVar.j();
        }
    }

    public void r() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && o() && (textView = this.f62846a) != null) {
            int i2 = this.f62848c;
            if (i2 == 1) {
                textView.setText(R.string.level_sort);
            } else if (i2 == 2) {
                textView.setText(R.string.update_sort);
            }
            this.f62846a.setOnClickListener(this.j);
            s(this.f62853h);
        }
    }

    public final void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            int i2 = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
            f fVar = this.f62852g;
            d.a.s0.l0.d.c n = fVar != null ? fVar.n() : null;
            if (n != null && n.f62780a) {
                f fVar2 = this.f62852g;
                if (fVar2 != null && fVar2.t()) {
                    SkinManager.setViewTextColor(this.f62846a, R.color.CAM_X0107);
                    this.f62846a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                    return;
                }
                SkinManager.setViewTextColor(this.f62846a, R.color.CAM_X0107);
                this.f62846a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.f62846a, R.color.CAM_X0107);
            this.f62846a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i2, R.color.CAM_X0108, null), (Drawable) null);
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && o()) {
            this.f62848c = i2;
            r();
        }
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f62851f = dVar;
        }
    }

    public void v(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, textView) == null) {
            this.f62846a = textView;
        }
    }
}
