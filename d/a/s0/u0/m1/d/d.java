package d.a.s0.u0.m1.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends d.a.s0.u0.k<d.a.s0.h3.x, a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean x;
    public boolean y;

    /* loaded from: classes9.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f66312a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f66313b;

        /* renamed from: c  reason: collision with root package name */
        public View f66314c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f66315d;

        /* renamed from: e  reason: collision with root package name */
        public View f66316e;

        /* renamed from: f  reason: collision with root package name */
        public View f66317f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f66318g;

        /* renamed from: h  reason: collision with root package name */
        public View f66319h;

        /* renamed from: i  reason: collision with root package name */
        public View f66320i;
        public View j;
        public List<View> k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = new ArrayList();
            this.f66313b = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.f66312a = view.findViewById(R.id.frs_fortune_bag_item);
            this.f66314c = view.findViewById(R.id.frs_my_service_item);
            this.f66315d = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.f66316e = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.f66317f = view.findViewById(R.id.frs_bawu_center);
            this.f66318g = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.f66319h = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.f66320i = view.findViewById(R.id.official_account_text_divider_service_top);
            this.j = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.k.add(this.f66319h);
            this.k.add(this.f66320i);
            this.k.add(this.j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.y = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || this.p == null) {
            return;
        }
        int id = view.getId();
        int intValue = ((Integer) view.getTag()).intValue();
        if (z(intValue) instanceof b2) {
            b2 b2Var = (b2) z(intValue);
            this.p.a(id, intValue, view, f0(this.q.getListView(), intValue), b2Var);
        }
    }

    public final void v0(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            List<View> list = aVar.k;
            for (View view : list) {
                view.setVisibility(8);
            }
            list.get(0).setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: w0 */
    public a Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new a(LayoutInflater.from(this.f44821e).inflate(R.layout.frs_extra_account_item, (ViewGroup) null)) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.u0.k, d.a.c.k.e.a
    /* renamed from: x0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.s0.h3.x xVar, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, xVar, aVar})) == null) {
            super.X(i2, view, viewGroup, xVar, aVar);
            boolean z = true;
            if (xVar.t4()) {
                String r4 = xVar.r4();
                if (r4 != null) {
                    aVar.f66313b.setText(r4);
                } else {
                    FrsViewData frsViewData = this.n;
                    if (frsViewData != null && frsViewData.getForum() != null && this.n.getForum().getName() != null) {
                        TextView textView = aVar.f66313b;
                        Context context = this.f44821e;
                        int i3 = R.string.get_fortune_hint_format;
                        Object[] objArr = new Object[1];
                        FrsViewData frsViewData2 = this.n;
                        objArr[0] = frsViewData2 == null ? "" : frsViewData2.getForum().getName();
                        textView.setText(context.getString(i3, objArr));
                    }
                }
                aVar.f66312a.setTag(Integer.valueOf(i2));
                aVar.f66312a.setOnClickListener(this);
                aVar.f66312a.setVisibility(0);
            } else {
                aVar.f66312a.setVisibility(8);
                aVar.f66319h.setVisibility(8);
            }
            d.a.s0.h3.r s4 = xVar.s4();
            if (s4 != null && s4.b() && !TextUtils.isEmpty(s4.a())) {
                aVar.f66315d.setText(s4.a());
                aVar.f66314c.setTag(Integer.valueOf(i2));
                aVar.f66314c.setOnClickListener(this);
                aVar.f66314c.setVisibility(0);
            } else {
                aVar.f66314c.setVisibility(8);
                aVar.f66320i.setVisibility(8);
            }
            if (this.y) {
                aVar.f66316e.setVisibility(0);
            } else {
                aVar.f66316e.setVisibility(8);
            }
            this.o.getLayoutMode().k(this.r == 1);
            this.o.getLayoutMode().j(view);
            FrsViewData frsViewData3 = this.n;
            z = (frsViewData3 == null || frsViewData3.getUserData() == null || !this.n.getUserData().isBawu()) ? false : false;
            if (z) {
                aVar.f66317f.setVisibility(0);
                SkinManager.setBackgroundResource(aVar.f66317f, R.drawable.frs_top_item_bg);
                aVar.f66316e.setVisibility(0);
                aVar.f66317f.setOnClickListener(this);
                aVar.f66317f.setTag(Integer.valueOf(i2));
            } else {
                aVar.f66317f.setVisibility(8);
                aVar.j.setVisibility(8);
            }
            if (this.x || xVar.t4()) {
                return view;
            }
            if (z) {
                aVar.f66312a.setVisibility(8);
                aVar.f66314c.setVisibility(8);
                v0(aVar);
                return view;
            }
            return new View(this.f44821e);
        }
        return (View) invokeCommon.objValue;
    }
}
