package d.a.q0.e1.e.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.q0.e1.e.c.a> f55798e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f55799f;

    /* renamed from: g  reason: collision with root package name */
    public int f55800g;

    /* renamed from: h  reason: collision with root package name */
    public int f55801h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f55802i;
    public boolean j;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.q0.e1.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1340b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f55803a;

        /* renamed from: b  reason: collision with root package name */
        public BarImageView f55804b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f55805c;

        public C1340b(b bVar) {
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

        public /* synthetic */ C1340b(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b(TbPageContext tbPageContext, int i2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2), bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55800g = -1;
        this.j = false;
        this.f55799f = tbPageContext;
        this.f55802i = bdUniqueId;
        this.f55801h = i2;
        this.f55800g = d.a.p0.s.d0.b.j().k("key_game_video_tab_has_choosed_sub_class_id", -1);
    }

    public final void a(C1340b c1340b) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c1340b) == null) || c1340b == null) {
            return;
        }
        SkinManager.setViewTextColor(c1340b.f55803a, R.color.CAM_X0107);
        SkinManager.setImageResource(c1340b.f55805c, R.drawable.icon_game_video_tab_choose_select);
    }

    public void b(List<d.a.q0.e1.e.c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f55798e = list;
            if (this.j || ListUtils.isEmpty(list)) {
                return;
            }
            for (d.a.q0.e1.e.c.a aVar : list) {
                if (!StringUtils.isNull(aVar.f55860c)) {
                    d.a.d.e.l.d.h().m(aVar.f55860c, 10, null, this.f55802i);
                }
            }
            this.j = true;
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f55800g = i2;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ListUtils.getCount(this.f55798e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? ListUtils.getItem(this.f55798e, i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        C1340b c1340b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1340b = new C1340b(this, null);
                view2 = LayoutInflater.from(this.f55799f.getPageActivity()).inflate(R.layout.game_video_choose_item_layout, (ViewGroup) null);
                c1340b.f55803a = (TextView) view2.findViewById(R.id.id_game_video_choose_item_title);
                c1340b.f55804b = (BarImageView) view2.findViewById(R.id.id_game_video_choose_item_photo);
                c1340b.f55805c = (ImageView) view2.findViewById(R.id.id_game_video_choose_item_selected);
                c1340b.f55804b.setShowOval(true);
                c1340b.f55804b.setAutoChangeStyle(true);
                c1340b.f55804b.setBorderColor(this.f55799f.getResources().getColor(R.color.black_alpha8));
                c1340b.f55804b.setBorderWidth(this.f55799f.getResources().getDimensionPixelOffset(R.dimen.tbds3));
                view2.setTag(c1340b);
            } else {
                view2 = view;
                c1340b = (C1340b) view.getTag();
            }
            a(c1340b);
            d.a.q0.e1.e.c.a aVar = (d.a.q0.e1.e.c.a) ListUtils.getItem(this.f55798e, i2);
            if (aVar != null) {
                c1340b.f55803a.setText(StringUtils.isNull(aVar.f55859b) ? "" : aVar.f55859b);
                c1340b.f55804b.M(aVar.f55860c, 10, false);
                if (aVar.f55861d == 1) {
                    c1340b.f55804b.setAlpha(1);
                    c1340b.f55803a.setAlpha(1.0f);
                } else {
                    c1340b.f55804b.setAlpha(0.5f);
                    c1340b.f55803a.setAlpha(0.5f);
                }
                if (aVar.f55858a == this.f55800g && this.f55801h != 101) {
                    c1340b.f55805c.setVisibility(0);
                } else {
                    c1340b.f55805c.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
