package d.a.s0.h2.o.k;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.s0.h2.h.o;
import d.a.s0.h3.h0.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f61104a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f61105b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f61106c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f61107d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f61108e;

    /* renamed from: f  reason: collision with root package name */
    public int f61109f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f61110g;

    /* renamed from: h  reason: collision with root package name */
    public int f61111h;

    /* renamed from: i  reason: collision with root package name */
    public int f61112i;
    public SortSwitchButton.f j;
    public View.OnClickListener k;

    /* loaded from: classes9.dex */
    public class a implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f61113a;

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
            this.f61113a = bVar;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f61113a.f61108e != null) {
                    return this.f61113a.f61108e.a(i2);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* renamed from: d.a.s0.h2.o.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1489b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f61114e;

        public View$OnClickListenerC1489b(b bVar) {
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
            this.f61114e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f61114e.f61110g != null) {
                    this.f61114e.f61110g.onClick(view);
                }
                if (j.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        if (view != this.f61114e.f61105b) {
                            if (view == this.f61114e.f61106c) {
                                this.f61114e.k(1);
                                return;
                            }
                            return;
                        }
                        this.f61114e.k(0);
                    }
                }
            }
        }
    }

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61109f = 0;
        this.j = new a(this);
        this.k = new View$OnClickListenerC1489b(this);
        if (view == null) {
            return;
        }
        this.f61104a = view;
        TextView textView = (TextView) view.findViewById(R.id.all_reply);
        this.f61105b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f61104a.findViewById(R.id.owner_reply);
        this.f61106c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f61104a.findViewById(R.id.video_pb_sort_switch_btn);
        this.f61107d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.j);
        this.f61107d.u(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null) {
            return;
        }
        int i2 = 0;
        if (oVar.f60175f == o.l) {
            this.f61105b.setClickable(true);
            this.f61105b.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f61106c.setVisibility(0);
            f(oVar.f60177h);
        }
        if (oVar.f60178i) {
            this.f61106c.setVisibility(8);
            this.f61107d.setVisibility(8);
        } else if (oVar.j) {
            this.f61106c.setVisibility(8);
        } else {
            this.f61106c.setVisibility(0);
        }
        if (!oVar.f60178i && oVar.k != null) {
            this.f61107d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < oVar.k.size()) {
                    if (oVar.k.get(i3) != null && oVar.f60176g == oVar.k.get(i3).sort_type.intValue()) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            g(oVar.k, i2);
        }
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                k(1);
            } else {
                k(0);
            }
        }
    }

    public void g(List<PbSortType> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i2) == null) {
            if (ListUtils.isEmpty(list)) {
                this.f61107d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                r rVar = new r();
                rVar.c(pbSortType.sort_type.intValue());
                rVar.d(pbSortType.sort_name);
                arrayList.add(rVar);
            }
            this.f61107d.setVisibility(0);
            this.f61107d.setData(arrayList, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f61104a, R.color.CAM_X0205);
            this.f61112i = SkinManager.getColor(R.color.CAM_X0105);
            this.f61111h = SkinManager.getColor(R.color.CAM_X0107);
            k(this.f61109f);
            this.f61107d.F();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f61110g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f61108e = fVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f61109f = i2;
            if (i2 == 0) {
                this.f61105b.setTypeface(Typeface.defaultFromStyle(1));
                this.f61106c.setTypeface(Typeface.defaultFromStyle(0));
                this.f61105b.setTextColor(this.f61112i);
                this.f61106c.setTextColor(this.f61111h);
            } else if (i2 == 1) {
                this.f61105b.setTypeface(Typeface.defaultFromStyle(0));
                this.f61106c.setTypeface(Typeface.defaultFromStyle(1));
                this.f61105b.setTextColor(this.f61111h);
                this.f61106c.setTextColor(this.f61112i);
            }
        }
    }
}
