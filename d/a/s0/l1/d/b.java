package d.a.s0.l1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LabelRecommendActivity f63211a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f63212b;

    /* renamed from: c  reason: collision with root package name */
    public View f63213c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63214d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f63215e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f63216f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f63217g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.l1.a.a f63218h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.l1.d.a f63219i;
    public View.OnClickListener j;
    public List<d.a.s0.l1.b.a> k;
    public List<Integer> l;
    public View.OnClickListener m;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f63220e;

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
            this.f63220e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof d.a.s0.l1.b.a)) {
                Integer valueOf = Integer.valueOf(((d.a.s0.l1.b.a) view.getTag()).f63200a);
                if (this.f63220e.l.contains(valueOf)) {
                    this.f63220e.l.remove(valueOf);
                } else {
                    this.f63220e.l.add(valueOf);
                }
                this.f63220e.i();
            }
        }
    }

    public b(LabelRecommendActivity labelRecommendActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {labelRecommendActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new a(this);
        if (labelRecommendActivity == null) {
            return;
        }
        this.f63211a = labelRecommendActivity;
        g();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f63212b : (View) invokeV.objValue;
    }

    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList(this.l);
            arrayList.add(0, Integer.valueOf(this.f63219i.b()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63214d : (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f63216f : (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f63211a.setContentView(R.layout.activity_label_recommend);
            this.f63212b = (ViewGroup) this.f63211a.findViewById(R.id.view_root);
            this.f63213c = this.f63211a.findViewById(R.id.statebar_view);
            this.f63214d = (TextView) this.f63211a.findViewById(R.id.skip);
            this.f63215e = (NoNetworkView) this.f63211a.findViewById(R.id.view_no_network);
            this.f63216f = (TextView) this.f63211a.findViewById(R.id.sub_label);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f63213c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
            }
            l(0, 0);
            this.f63217g = (BdListView) this.f63211a.findViewById(R.id.listview);
            d.a.s0.l1.a.a aVar = new d.a.s0.l1.a.a(this.f63211a.getPageContext().getPageActivity());
            this.f63218h = aVar;
            aVar.b(this.m);
            d.a.s0.l1.d.a aVar2 = new d.a.s0.l1.d.a(this.f63211a.getPageContext().getPageActivity());
            this.f63219i = aVar2;
            this.f63217g.addHeaderView(aVar2.a());
            this.f63217g.setAdapter((ListAdapter) this.f63218h);
            h();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f63214d, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f63216f, R.drawable.color_sub_lable_selector);
            SkinManager.setBackgroundResource(this.f63216f, R.drawable.bule_bg_commen_label_button);
            this.f63215e.c(this.f63211a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (d.a.s0.l1.b.a aVar : this.k) {
                if (aVar != null) {
                    aVar.f63202c = this.l.contains(Integer.valueOf(aVar.f63200a));
                }
            }
            this.f63218h.a(this.k);
            l(this.l.size(), this.k.size());
        }
    }

    public void j(d.a.s0.l1.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || bVar == null || bVar.c() == null || bVar.b() == null) {
            return;
        }
        for (d.a.s0.l1.b.a aVar : bVar.b()) {
            if (aVar != null) {
                aVar.f63202c = false;
            }
        }
        this.k.clear();
        this.k.addAll(bVar.b());
        this.f63219i.d(bVar.c());
        this.f63218h.a(this.k);
        this.f63217g.setVisibility(0);
        l(0, this.k.size());
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.j = onClickListener;
            this.f63214d.setOnClickListener(onClickListener);
        }
    }

    public final void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f63216f.setEnabled(i2 > 0);
            this.f63216f.setText(this.f63211a.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
            this.f63216f.setOnClickListener(i2 > 0 ? this.j : null);
        }
    }
}
