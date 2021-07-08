package d.a.p0.v1.h.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TailManagementActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.memberCenter.tail.data.TailDataList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.o0.r.s.a;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f65305e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.p0.v1.h.e.g f65306f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f65307g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f65308h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f65309i;
    public View.OnClickListener j;
    public d.a.p0.v1.h.f.a<Integer> k;
    public d.a.p0.v1.h.f.a<Void> l;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65310e;

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
            this.f65310e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TailManagementActivityConfig tailManagementActivityConfig = new TailManagementActivityConfig(view.getContext());
                tailManagementActivityConfig.getIntent().putExtra("list", new TailDataList(this.f65310e.f65306f.i()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tailManagementActivityConfig));
            }
        }
    }

    /* renamed from: d.a.p0.v1.h.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1802b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65311e;

        public View$OnClickListenerC1802b(b bVar) {
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
            this.f65311e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f65311e.f65305e, 1, false, 6);
                memberPayActivityConfig.setSceneId("4009001001");
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_TAILS_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65312e;

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
            this.f65312e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view.getTag() == null) {
                return;
            }
            if (!this.f65312e.f65306f.g()) {
                b bVar = this.f65312e;
                bVar.i(bVar.f65305e.getString(R.string.become_member_to_use));
                return;
            }
            TailData b2 = ((d.a.p0.v1.h.e.e) view.getTag()).b();
            this.f65312e.f65306f.o(b2.getId(), !b2.isSelected());
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65313e;

        public d(b bVar) {
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
            this.f65313e = bVar;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f65313e.f65305e, 1, false, 6);
                memberPayActivityConfig.setSceneId("4009001001");
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_TAILS_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(b bVar) {
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
                }
            }
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.a.p0.v1.h.f.a<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f65314a;

        public f(b bVar) {
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
            this.f65314a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.v1.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, num}) == null) {
                if (z) {
                    l.M(this.f65314a.f65305e, str);
                } else if (num != null && this.f65314a.f65306f.i() != null && this.f65314a.f65306f.i().size() != 0) {
                    for (TailData tailData : this.f65314a.f65306f.i()) {
                        if (tailData.getId() == num.intValue()) {
                            tailData.setSelected(!tailData.isSelected());
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001344, Boolean.valueOf(tailData.isSelected())));
                        } else {
                            tailData.setSelected(false);
                        }
                    }
                    this.f65314a.notifyDataSetChanged();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements d.a.p0.v1.h.f.a<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f65315a;

        public g(b bVar) {
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
            this.f65315a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.v1.h.f.a
        /* renamed from: b */
        public void a(boolean z, String str, Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, r7}) == null) {
                if (z) {
                    l.M(this.f65315a.f65305e, str);
                } else {
                    this.f65315a.notifyDataSetChanged();
                }
            }
        }
    }

    public b(Context context, d.a.p0.v1.h.e.g gVar, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, gVar, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65308h = new a(this);
        this.f65309i = new View$OnClickListenerC1802b(this);
        this.j = new c(this);
        this.k = new f(this);
        this.l = new g(this);
        this.f65305e = context;
        this.f65307g = onClickListener;
        this.f65306f = gVar;
        gVar.n(this.k);
        this.f65306f.p(this.l);
    }

    public final View d(View view) {
        InterceptResult invokeL;
        d.a.p0.v1.h.e.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            if (view != null && (view.getTag() instanceof d.a.p0.v1.h.e.c)) {
                cVar = (d.a.p0.v1.h.e.c) view.getTag();
            } else {
                cVar = new d.a.p0.v1.h.e.c();
                view = cVar.a(this.f65305e);
                cVar.c(this.f65307g);
                cVar.b();
            }
            cVar.d(3);
            return view;
        }
        return (View) invokeL.objValue;
    }

    public final View e(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            if (view == null || !(view.getTag() instanceof d.a.p0.v1.h.e.d)) {
                d.a.p0.v1.h.e.d dVar = new d.a.p0.v1.h.e.d();
                View a2 = dVar.a(this.f65305e);
                dVar.c(this.f65308h);
                dVar.b();
                return a2;
            }
            return view;
        }
        return (View) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public TailData getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 >= this.f65306f.i().size()) {
                return null;
            }
            return this.f65306f.i().get(i2);
        }
        return (TailData) invokeI.objValue;
    }

    public final View g(TailData tailData, View view) {
        InterceptResult invokeLL;
        d.a.p0.v1.h.e.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tailData, view)) == null) {
            if (tailData == null) {
                return null;
            }
            if (view != null && (view.getTag() instanceof d.a.p0.v1.h.e.e)) {
                eVar = (d.a.p0.v1.h.e.e) view.getTag();
            } else {
                eVar = new d.a.p0.v1.h.e.e();
                view = eVar.a(this.f65305e);
                eVar.e(this.j);
                eVar.c();
            }
            eVar.f(tailData);
            eVar.h(tailData);
            return view;
        }
        return (View) invokeLL.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f65306f.i().size() + 1 : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (this.f65306f.i().size() == 0) {
                return 2;
            }
            return i2 == this.f65306f.i().size() ? 1 : 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            if (getItemViewType(i2) == 0) {
                return g(getItem(i2), view);
            }
            if (getItemViewType(i2) == 1) {
                return e(view);
            }
            if (getItemViewType(i2) == 2) {
                return d(view);
            }
            if (getItemViewType(i2) == 3) {
                return h(view);
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    public final View h(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view)) == null) {
            if (view == null || !(view.getTag() instanceof d.a.p0.v1.h.e.f)) {
                d.a.p0.v1.h.e.f fVar = new d.a.p0.v1.h.e.f();
                View a2 = fVar.a(this.f65305e);
                fVar.c(this.f65309i);
                fVar.b();
                return a2;
            }
            return view;
        }
        return (View) invokeL.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void i(String str) {
        d.a.c.a.f<?> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (a2 = j.a(this.f65305e)) == null) {
            return;
        }
        d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(a2.getPageActivity());
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setMessage(str).setNegativeButton(this.f65305e.getString(R.string.cancel), new e(this)).setPositiveButton(this.f65305e.getString(R.string.open_now), new d(this)).create(a2).show();
    }
}
