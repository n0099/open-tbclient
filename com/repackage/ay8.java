package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hz8;
import com.repackage.kz5;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes5.dex */
public class ay8 implements kz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hz8 a;
    public ArrayList<TransmitForumData> b;
    public List<SimpleForum> c;
    public kz5.a d;
    public boolean e;
    public int f;
    public hz8.b g;

    /* loaded from: classes5.dex */
    public class a implements hz8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ay8 a;

        public a(ay8 ay8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ay8Var;
        }

        @Override // com.repackage.hz8.b
        public void a(List<SimpleForum> list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
                this.a.c = list;
                this.a.f = i;
                this.a.h();
            }
        }

        @Override // com.repackage.hz8.b
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.g();
            }
        }
    }

    public ay8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList<>();
        this.g = new a(this);
        BdUniqueId gen = BdUniqueId.gen();
        hz8 hz8Var = new hz8(gen);
        this.a = hz8Var;
        hz8Var.i(this.g);
        this.a.j(gen);
    }

    @Override // com.repackage.kz5
    public void a(kz5.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.d = aVar;
        }
    }

    @Override // com.repackage.kz5
    public void b() {
        hz8 hz8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.d == null || (hz8Var = this.a) == null) {
            return;
        }
        this.e = false;
        hz8Var.l(null);
        this.a.k(null);
        this.a.h();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.e) {
            return;
        }
        kz5.a aVar = this.d;
        if (aVar != null) {
            aVar.a(null, false, 2, 0);
        }
        this.e = true;
    }

    public final void h() {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.clear();
            if (ListUtils.getCount(this.c) > 0) {
                for (SimpleForum simpleForum : this.c) {
                    if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                        TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                        transmitForumData.tabItemDatas = new ArrayList<>();
                        for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                                transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                            }
                        }
                        this.b.add(transmitForumData);
                    }
                }
            }
            kz5.a aVar = this.d;
            if (aVar != null) {
                aVar.a(this.b, true, 2, this.f);
            }
        }
    }
}
