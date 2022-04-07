package com.repackage;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.downloadmanager.ui.adapter.ItemCardViewWrapperAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class h36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    public BdTypeRecyclerView b;
    public ItemCardViewWrapperAdapter c;
    public List<ho> d;
    public int e;
    public int f;

    public h36(BaseFragment baseFragment, BdTypeRecyclerView bdTypeRecyclerView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bdTypeRecyclerView, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
        this.a = baseFragment;
        this.b = bdTypeRecyclerView;
        this.e = i;
        this.f = i2;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ItemCardViewWrapperAdapter itemCardViewWrapperAdapter = new ItemCardViewWrapperAdapter(this.a.getContext(), x26.e, this.e, this.b, this.f);
            this.c = itemCardViewWrapperAdapter;
            this.d.add(itemCardViewWrapperAdapter);
            this.b.a(this.d);
        }
    }
}
