package d.a.s0.u0.a2.f;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.h3.h0.m;
import java.util.HashMap;
import java.util.List;
import tbclient.ItemInfo;
import tbclient.TagInfo;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f65762a;

    /* renamed from: b  reason: collision with root package name */
    public final FlowLabelLayout f65763b;

    /* renamed from: c  reason: collision with root package name */
    public List<TagInfo> f65764c;

    /* renamed from: d.a.s0.u0.a2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1706a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public View$OnClickListenerC1706a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view instanceof TBSpecificationBtn)) {
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) view;
                if (tBSpecificationBtn.f12660e instanceof HashMap) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkApplication.getInst().getApplicationContext(), "CatetoryRecommendList", (HashMap) tBSpecificationBtn.f12660e)));
                    Object tag = view.getTag(R.id.item_tag_data);
                    if (tag instanceof Integer) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new d.a.s0.u0.a2.h.a(2, ((Integer) tag).intValue())));
                    }
                }
            }
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65762a = context;
        FlowLabelLayout flowLabelLayout = new FlowLabelLayout(context);
        this.f65763b = flowLabelLayout;
        flowLabelLayout.setPadding(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005), 0);
        this.f65763b.setHorizontalSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X006));
        this.f65763b.setVerticalSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65763b : (View) invokeV.objValue;
    }

    public final View b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            d.a.r0.r.f0.m.b bVar = new d.a.r0.r.f0.m.b();
            bVar.i(0, R.drawable.icon_pure_arrow12_right, TBSpecificationButtonConfig.IconType.WEBP);
            bVar.h(R.color.CAM_X0107);
            bVar.g(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds31));
            bVar.f(0);
            bVar.r(R.color.CAM_X0105);
            bVar.j(1, 0);
            bVar.m(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
            bVar.l(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X006), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.f65762a);
            tBSpecificationBtn.setConfig(bVar);
            if (tBSpecificationBtn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) tBSpecificationBtn.getLayoutParams()).rightMargin = this.f65762a.getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            }
            tBSpecificationBtn.setTag(R.id.item_tag_data, Integer.valueOf(i2));
            tBSpecificationBtn.setOnClickListener(new View$OnClickListenerC1706a(this));
            return tBSpecificationBtn;
        }
        return (View) invokeI.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.f65763b, R.color.CAM_X0205);
            if (this.f65763b != null) {
                for (int i2 = 0; i2 < this.f65763b.getChildCount(); i2++) {
                    if (this.f65763b.getChildAt(i2) instanceof TBSpecificationBtn) {
                        ((TBSpecificationBtn) this.f65763b.getChildAt(i2)).k();
                    }
                }
            }
        }
    }

    public void d(ItemInfo itemInfo) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, itemInfo) == null) || itemInfo == null || ListUtils.isEmpty(itemInfo.tag_info)) {
            return;
        }
        List<TagInfo> list = itemInfo.tag_info;
        if (ListUtils.getCount(this.f65764c) != ListUtils.getCount(list)) {
            this.f65763b.removeAllViews();
            z = true;
        } else {
            z = false;
        }
        for (int i2 = 0; i2 < ListUtils.getCount(list); i2++) {
            TagInfo tagInfo = (TagInfo) ListUtils.getItem(list, i2);
            if (tagInfo != null) {
                if (z) {
                    this.f65763b.addView(b(i2 + 1));
                }
                View childAt = this.f65763b.getChildAt(i2);
                if (childAt instanceof TBSpecificationBtn) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("tab_id", String.valueOf(tagInfo.tab_id));
                    hashMap.put("tab_name", tagInfo.tag_name);
                    hashMap.put("rank_type", String.valueOf(tagInfo.rank_type));
                    hashMap.put("class_id", String.valueOf(tagInfo.class_id));
                    hashMap.put("home_tab_name", itemInfo.template_name);
                    TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) childAt;
                    tBSpecificationBtn.setText(tagInfo.tag_name);
                    tBSpecificationBtn.f12660e = hashMap;
                    tBSpecificationBtn.k();
                }
            }
        }
        this.f65764c = list;
    }
}
