package d.a.o0.a.z1.b.b;

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
import d.a.o0.a.z1.b.b.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f49177h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f49178i;
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
        public CharSequence f49179a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f49180b;

        /* renamed from: c  reason: collision with root package name */
        public int f49181c;

        /* renamed from: d  reason: collision with root package name */
        public int f49182d;

        /* renamed from: e  reason: collision with root package name */
        public c f49183e;

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
            this.f49181c = -1;
            this.f49182d = -1;
            this.f49179a = charSequence;
            this.f49181c = i2;
            this.f49183e = cVar;
        }
    }

    /* renamed from: d.a.o0.a.z1.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1008b extends h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public List<a> f49184f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1008b(Context context) {
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
            this.f49184f = new ArrayList();
            k(false);
            t(false);
        }

        public C1008b a0(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (aVar != null) {
                    this.f49184f.add(aVar);
                }
                return this;
            }
            return (C1008b) invokeL.objValue;
        }

        @Override // d.a.o0.a.z1.b.b.h.a
        public h c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                b bVar = (b) super.c();
                bVar.n(this.f49184f);
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
        public TextView f49185a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49186b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f49187c;

        /* renamed from: d  reason: collision with root package name */
        public b f49188d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f49189e;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f49190e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f49191f;

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
                this.f49191f = dVar;
                this.f49190e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f49191f.f49188d.dismiss();
                    c cVar = this.f49190e.f49183e;
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
            this.f49189e = bVar;
            if (view != null) {
                this.f49185a = (TextView) view.findViewById(d.a.o0.a.f.hv_btn_text);
                this.f49186b = (TextView) view.findViewById(d.a.o0.a.f.hv_btn_subtext);
                this.f49187c = (LinearLayout) view;
                this.f49188d = bVar2;
            }
        }

        public void a(a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            this.f49185a.setText(aVar.f49179a);
            if (aVar.f49181c > 0) {
                this.f49185a.setTextColor(this.f49189e.f49178i.getResources().getColor(aVar.f49181c));
            }
            if (!TextUtils.isEmpty(aVar.f49180b)) {
                this.f49186b.setVisibility(0);
                this.f49186b.setText(aVar.f49180b);
            } else {
                this.f49186b.setVisibility(8);
            }
            if (aVar.f49182d > 0) {
                this.f49186b.setTextColor(this.f49189e.f49178i.getResources().getColor(aVar.f49182d));
            }
            this.f49187c.setOnClickListener(new a(this, aVar));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, d.a.o0.a.i.SwanAppNoTitleDialog);
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
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.k).inflate(d.a.o0.a.g.aiapps_item_hv_dialog, (ViewGroup) linearLayout, false);
            linearLayout2.setBackground(getContext().getResources().getDrawable(d.a.o0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
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
            view.setBackgroundColor(this.f49178i.getResources().getColor(d.a.o0.a.c.aiapps_dialog_gray));
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
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d.a.o0.a.g.aiapps_view_hv_dialog, c().e(), false);
            this.f49177h = viewGroup;
            this.f49178i = (FrameLayout) viewGroup.findViewById(d.a.o0.a.f.hv_content);
            this.l = this.f49177h.findViewById(d.a.o0.a.f.hv_divider);
            this.j = (FrameLayout) this.f49177h.findViewById(d.a.o0.a.f.hv_btn_content);
            View k = k(this.f49178i);
            if (k != null) {
                this.f49178i.addView(k);
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
            this.l.setBackgroundColor(getContext().getResources().getColor(d.a.o0.a.c.aiapps_dialog_gray));
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            m();
            c().W(this.f49177h);
        }
    }
}
