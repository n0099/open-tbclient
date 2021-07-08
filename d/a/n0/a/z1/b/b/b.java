package d.a.n0.a.z1.b.b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.z1.b.b.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f48673h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f48674i;
    public FrameLayout j;
    public Context k;
    public View l;
    public List<a> m;
    public int n;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f48675a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f48676b;

        /* renamed from: c  reason: collision with root package name */
        public int f48677c;

        /* renamed from: d  reason: collision with root package name */
        public int f48678d;

        /* renamed from: e  reason: collision with root package name */
        public c f48679e;

        public a(CharSequence charSequence, int i2, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charSequence, Integer.valueOf(i2), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48677c = -1;
            this.f48678d = -1;
            this.f48675a = charSequence;
            this.f48677c = i2;
            this.f48679e = cVar;
        }
    }

    /* renamed from: d.a.n0.a.z1.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0999b extends h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public List<a> f48680f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0999b(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48680f = new ArrayList();
            k(false);
            t(false);
        }

        public C0999b a0(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (aVar != null) {
                    this.f48680f.add(aVar);
                }
                return this;
            }
            return (C0999b) invokeL.objValue;
        }

        @Override // d.a.n0.a.z1.b.b.h.a
        public h c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                b bVar = (b) super.c();
                bVar.n(this.f48680f);
                return bVar;
            }
            return (h) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(View view);
    }

    /* loaded from: classes7.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f48681a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f48682b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f48683c;

        /* renamed from: d  reason: collision with root package name */
        public b f48684d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f48685e;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f48686e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f48687f;

            public a(d dVar, a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48687f = dVar;
                this.f48686e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f48687f.f48684d.dismiss();
                    c cVar = this.f48686e.f48679e;
                    if (cVar != null) {
                        cVar.a(view);
                    }
                }
            }
        }

        public d(b bVar, View view, b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48685e = bVar;
            if (view != null) {
                this.f48681a = (TextView) view.findViewById(d.a.n0.a.f.hv_btn_text);
                this.f48682b = (TextView) view.findViewById(d.a.n0.a.f.hv_btn_subtext);
                this.f48683c = (LinearLayout) view;
                this.f48684d = bVar2;
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.f48681a.setText(aVar.f48675a);
            if (aVar.f48677c > 0) {
                this.f48681a.setTextColor(this.f48685e.f48674i.getResources().getColor(aVar.f48677c));
            }
            if (!TextUtils.isEmpty(aVar.f48676b)) {
                this.f48682b.setVisibility(0);
                this.f48682b.setText(aVar.f48676b);
            } else {
                this.f48682b.setVisibility(8);
            }
            if (aVar.f48678d > 0) {
                this.f48682b.setTextColor(this.f48685e.f48674i.getResources().getColor(aVar.f48678d));
            }
            this.f48683c.setOnClickListener(new a(this, aVar));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, d.a.n0.a.i.SwanAppNoTitleDialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new ArrayList();
        this.n = 2;
    }

    public final LinearLayout i(a aVar, LinearLayout linearLayout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, linearLayout)) == null) {
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.k).inflate(d.a.n0.a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
            linearLayout2.setBackground(getContext().getResources().getDrawable(d.a.n0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
            new d(this, linearLayout2, this).a(aVar);
            return linearLayout2;
        }
        return (LinearLayout) invokeLL.objValue;
    }

    public final void j(List<a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.k);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (list.size() > this.n) {
            linearLayout.setOrientation(1);
        } else {
            linearLayout.setOrientation(0);
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            linearLayout.addView(i(list.get(i2), linearLayout));
            if (i2 < list.size() - 1) {
                if (list.size() > this.n) {
                    linearLayout.addView(l(1));
                } else {
                    linearLayout.addView(l(0));
                }
            }
        }
        this.j.removeAllViews();
        this.j.addView(linearLayout);
    }

    public View k(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return null;
        }
        return (View) invokeL.objValue;
    }

    public final View l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            View view = new View(this.k);
            view.setBackgroundColor(this.f48674i.getResources().getColor(d.a.n0.a.c.aiapps_dialog_gray));
            if (i2 == 1) {
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            } else {
                view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
            }
            return view;
        }
        return (View) invokeI.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = getContext();
            this.k = context;
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d.a.n0.a.g.aiapps_view_hv_dialog, c().e(), false);
            this.f48673h = viewGroup;
            this.f48674i = (FrameLayout) viewGroup.findViewById(d.a.n0.a.f.hv_content);
            this.l = this.f48673h.findViewById(d.a.n0.a.f.hv_divider);
            this.j = (FrameLayout) this.f48673h.findViewById(d.a.n0.a.f.hv_btn_content);
            View k = k(this.f48674i);
            if (k != null) {
                this.f48674i.addView(k);
            }
            o();
            j(this.m);
        }
    }

    public final void n(List<a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.m.clear();
            if (list != null) {
                this.m.addAll(list);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l.setBackgroundColor(getContext().getResources().getColor(d.a.n0.a.c.aiapps_dialog_gray));
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            m();
            c().W(this.f48673h);
        }
    }
}
