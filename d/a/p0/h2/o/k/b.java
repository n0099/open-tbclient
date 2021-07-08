package d.a.p0.h2.o.k;

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
import d.a.p0.h2.h.o;
import d.a.p0.h3.h0.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f57860a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57861b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57862c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f57863d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f57864e;

    /* renamed from: f  reason: collision with root package name */
    public int f57865f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f57866g;

    /* renamed from: h  reason: collision with root package name */
    public int f57867h;

    /* renamed from: i  reason: collision with root package name */
    public int f57868i;
    public SortSwitchButton.f j;
    public View.OnClickListener k;

    /* loaded from: classes8.dex */
    public class a implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f57869a;

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
            this.f57869a = bVar;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f57869a.f57864e != null) {
                    return this.f57869a.f57864e.a(i2);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* renamed from: d.a.p0.h2.o.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1444b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57870e;

        public View$OnClickListenerC1444b(b bVar) {
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
            this.f57870e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f57870e.f57866g != null) {
                    this.f57870e.f57866g.onClick(view);
                }
                if (j.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        if (view != this.f57870e.f57861b) {
                            if (view == this.f57870e.f57862c) {
                                this.f57870e.k(1);
                                return;
                            }
                            return;
                        }
                        this.f57870e.k(0);
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
        this.f57865f = 0;
        this.j = new a(this);
        this.k = new View$OnClickListenerC1444b(this);
        if (view == null) {
            return;
        }
        this.f57860a = view;
        TextView textView = (TextView) view.findViewById(R.id.all_reply);
        this.f57861b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f57860a.findViewById(R.id.owner_reply);
        this.f57862c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f57860a.findViewById(R.id.video_pb_sort_switch_btn);
        this.f57863d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.j);
        this.f57863d.u(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null) {
            return;
        }
        int i2 = 0;
        if (oVar.f56931f == o.l) {
            this.f57861b.setClickable(true);
            this.f57861b.setText(TbadkCoreApplication.getInst().getString(R.string.all_reply));
            this.f57862c.setVisibility(0);
            f(oVar.f56933h);
        }
        if (oVar.f56934i) {
            this.f57862c.setVisibility(8);
            this.f57863d.setVisibility(8);
        } else if (oVar.j) {
            this.f57862c.setVisibility(8);
        } else {
            this.f57862c.setVisibility(0);
        }
        if (!oVar.f56934i && oVar.k != null) {
            this.f57863d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < oVar.k.size()) {
                    if (oVar.k.get(i3) != null && oVar.f56932g == oVar.k.get(i3).sort_type.intValue()) {
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
                this.f57863d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                r rVar = new r();
                rVar.c(pbSortType.sort_type.intValue());
                rVar.d(pbSortType.sort_name);
                arrayList.add(rVar);
            }
            this.f57863d.setVisibility(0);
            this.f57863d.setData(arrayList, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f57860a, R.color.CAM_X0205);
            this.f57868i = SkinManager.getColor(R.color.CAM_X0105);
            this.f57867h = SkinManager.getColor(R.color.CAM_X0107);
            k(this.f57865f);
            this.f57863d.F();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f57866g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f57864e = fVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f57865f = i2;
            if (i2 == 0) {
                this.f57861b.setTypeface(Typeface.defaultFromStyle(1));
                this.f57862c.setTypeface(Typeface.defaultFromStyle(0));
                this.f57861b.setTextColor(this.f57868i);
                this.f57862c.setTextColor(this.f57867h);
            } else if (i2 == 1) {
                this.f57861b.setTypeface(Typeface.defaultFromStyle(0));
                this.f57862c.setTypeface(Typeface.defaultFromStyle(1));
                this.f57861b.setTextColor(this.f57867h);
                this.f57862c.setTextColor(this.f57868i);
            }
        }
    }
}
