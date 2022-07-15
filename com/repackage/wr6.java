package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gift.giftTab.CategoryGiftListModel;
import com.baidu.tieba.gift.giftTab.DefaultGiftListModel;
import com.baidu.tieba.gift.giftTab.FreeGiftChanceModel;
import com.baidu.tieba.gift.giftTab.GiftTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class wr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d9<GiftTabActivity> a;
    public DefaultGiftListModel b;
    public CategoryGiftListModel c;
    public FreeGiftChanceModel d;
    public ArrayList<tr6> e;
    public ArrayList<rr6> f;
    public ArrayList<vr6> g;
    public HashMap<Integer, ArrayList<xo4>> h;
    public int i;
    public String j;
    public int k;
    public yo4 l;
    public e m;
    public d n;
    public DefaultGiftListModel.b o;
    public CategoryGiftListModel.b p;
    public FreeGiftChanceModel.b q;

    /* loaded from: classes7.dex */
    public class a implements DefaultGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr6 a;

        public a(wr6 wr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr6Var;
        }

        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.b
        public void a(int i, String str, int i2, String str2, int i3, yo4 yo4Var, ArrayList<rr6> arrayList, ArrayList<xo4> arrayList2, ArrayList<vr6> arrayList3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2, Integer.valueOf(i3), yo4Var, arrayList, arrayList2, arrayList3}) == null) {
                if (i == 0) {
                    int i4 = 0;
                    if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                        i4 = arrayList.get(0).a();
                    }
                    this.a.f = arrayList;
                    this.a.h.put(Integer.valueOf(i4), arrayList2);
                    this.a.g = arrayList3;
                    this.a.j = str2;
                    this.a.i = i2;
                    wr6 wr6Var = this.a;
                    wr6Var.k = i3;
                    wr6Var.l = yo4Var;
                    wr6Var.q();
                }
                if (this.a.m != null) {
                    e eVar = this.a.m;
                    String str3 = this.a.j;
                    wr6 wr6Var2 = this.a;
                    eVar.a(i, str, true, str3, wr6Var2.k, wr6Var2.l, wr6Var2.e, this.a.f, this.a.g);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements CategoryGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr6 a;

        public b(wr6 wr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr6Var;
        }

        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.b
        public void a(int i, String str, int i2, ArrayList<xo4> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), arrayList}) == null) {
                if (i == 0) {
                    this.a.h.put(Integer.valueOf(i2), arrayList);
                    this.a.q();
                }
                if (this.a.m != null) {
                    e eVar = this.a.m;
                    String str2 = this.a.j;
                    wr6 wr6Var = this.a;
                    eVar.a(i, str, false, str2, wr6Var.k, wr6Var.l, wr6Var.e, this.a.f, this.a.g);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements FreeGiftChanceModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr6 a;

        public c(wr6 wr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr6Var;
        }

        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.b
        public void a(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) && i == 0) {
                this.a.i = i2;
                if (this.a.n != null) {
                    this.a.n.a(this.a.i);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(int i, String str, boolean z, String str2, int i2, yo4 yo4Var, ArrayList<tr6> arrayList, ArrayList<rr6> arrayList2, ArrayList<vr6> arrayList3);
    }

    public wr6(d9<GiftTabActivity> d9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new HashMap<>();
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.a = d9Var;
        DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(d9Var);
        this.b = defaultGiftListModel;
        defaultGiftListModel.M(this.o);
        CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.a);
        this.c = categoryGiftListModel;
        categoryGiftListModel.E(this.p);
        FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.a);
        this.d = freeGiftChanceModel;
        freeGiftChanceModel.E(this.q);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.d == null) {
                FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.a);
                this.d = freeGiftChanceModel;
                freeGiftChanceModel.E(this.q);
            }
            this.d.D(str);
        }
    }

    public void o(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            if (this.b == null) {
                DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(this.a);
                this.b = defaultGiftListModel;
                defaultGiftListModel.M(this.o);
            }
            this.b.L(str, j);
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.c == null) {
                CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.a);
                this.c = categoryGiftListModel;
                categoryGiftListModel.E(this.p);
            }
            this.c.D(i);
        }
    }

    public final void q() {
        HashMap<Integer, ArrayList<xo4>> hashMap;
        ArrayList<rr6> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hashMap = this.h) == null || hashMap.size() <= 0 || (arrayList = this.f) == null || arrayList.size() <= 0) {
            return;
        }
        if (this.e == null) {
            this.e = new ArrayList<>();
        }
        this.e.clear();
        Iterator<rr6> it = this.f.iterator();
        while (it.hasNext()) {
            rr6 next = it.next();
            if (next != null && !StringUtils.isNull(next.b())) {
                tr6 tr6Var = new tr6();
                tr6Var.c(next.a());
                tr6Var.d(next.b());
                ArrayList<xo4> arrayList2 = this.h.get(Integer.valueOf(next.a()));
                if (arrayList2 != null) {
                    tr6Var.e(arrayList2);
                }
                this.e.add(tr6Var);
            }
        }
    }

    public void r(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.n = dVar;
        }
    }

    public void s(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.m = eVar;
        }
    }
}
