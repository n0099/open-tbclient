package d.a.q0.y0.b;

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
import d.a.p0.s.q.j0;
import d.a.p0.s.q.k0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.d.a.f<GiftTabActivity> f67008a;

    /* renamed from: b  reason: collision with root package name */
    public DefaultGiftListModel f67009b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryGiftListModel f67010c;

    /* renamed from: d  reason: collision with root package name */
    public FreeGiftChanceModel f67011d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.q0.y0.b.c> f67012e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.a.q0.y0.b.a> f67013f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.a.q0.y0.b.e> f67014g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<Integer, ArrayList<j0>> f67015h;

    /* renamed from: i  reason: collision with root package name */
    public int f67016i;
    public String j;
    public int k;
    public k0 l;
    public e m;
    public d n;
    public DefaultGiftListModel.b o;
    public CategoryGiftListModel.b p;
    public FreeGiftChanceModel.b q;

    /* loaded from: classes8.dex */
    public class a implements DefaultGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f67017a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67017a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.b
        public void a(int i2, String str, int i3, String str2, int i4, k0 k0Var, ArrayList<d.a.q0.y0.b.a> arrayList, ArrayList<j0> arrayList2, ArrayList<d.a.q0.y0.b.e> arrayList3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Integer.valueOf(i4), k0Var, arrayList, arrayList2, arrayList3}) == null) {
                if (i2 == 0) {
                    int i5 = 0;
                    if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                        i5 = arrayList.get(0).a();
                    }
                    this.f67017a.f67013f = arrayList;
                    this.f67017a.f67015h.put(Integer.valueOf(i5), arrayList2);
                    this.f67017a.f67014g = arrayList3;
                    this.f67017a.j = str2;
                    this.f67017a.f67016i = i3;
                    f fVar = this.f67017a;
                    fVar.k = i4;
                    fVar.l = k0Var;
                    fVar.q();
                }
                if (this.f67017a.m != null) {
                    e eVar = this.f67017a.m;
                    String str3 = this.f67017a.j;
                    f fVar2 = this.f67017a;
                    eVar.a(i2, str, true, str3, fVar2.k, fVar2.l, fVar2.f67012e, this.f67017a.f67013f, this.f67017a.f67014g);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements CategoryGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f67018a;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67018a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.b
        public void a(int i2, String str, int i3, ArrayList<j0> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), arrayList}) == null) {
                if (i2 == 0) {
                    this.f67018a.f67015h.put(Integer.valueOf(i3), arrayList);
                    this.f67018a.q();
                }
                if (this.f67018a.m != null) {
                    e eVar = this.f67018a.m;
                    String str2 = this.f67018a.j;
                    f fVar = this.f67018a;
                    eVar.a(i2, str, false, str2, fVar.k, fVar.l, fVar.f67012e, this.f67018a.f67013f, this.f67018a.f67014g);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements FreeGiftChanceModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f67019a;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67019a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.b
        public void a(int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) && i2 == 0) {
                this.f67019a.f67016i = i3;
                if (this.f67019a.n != null) {
                    this.f67019a.n.a(this.f67019a.f67016i);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(int i2);
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(int i2, String str, boolean z, String str2, int i3, k0 k0Var, ArrayList<d.a.q0.y0.b.c> arrayList, ArrayList<d.a.q0.y0.b.a> arrayList2, ArrayList<d.a.q0.y0.b.e> arrayList3);
    }

    public f(d.a.d.a.f<GiftTabActivity> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67015h = new HashMap<>();
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.f67008a = fVar;
        DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(fVar);
        this.f67009b = defaultGiftListModel;
        defaultGiftListModel.I(this.o);
        CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f67008a);
        this.f67010c = categoryGiftListModel;
        categoryGiftListModel.A(this.p);
        FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f67008a);
        this.f67011d = freeGiftChanceModel;
        freeGiftChanceModel.A(this.q);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f67011d == null) {
                FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f67008a);
                this.f67011d = freeGiftChanceModel;
                freeGiftChanceModel.A(this.q);
            }
            this.f67011d.z(str);
        }
    }

    public void o(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            if (this.f67009b == null) {
                DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(this.f67008a);
                this.f67009b = defaultGiftListModel;
                defaultGiftListModel.I(this.o);
            }
            this.f67009b.H(str, j);
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f67010c == null) {
                CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f67008a);
                this.f67010c = categoryGiftListModel;
                categoryGiftListModel.A(this.p);
            }
            this.f67010c.z(i2);
        }
    }

    public final void q() {
        HashMap<Integer, ArrayList<j0>> hashMap;
        ArrayList<d.a.q0.y0.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hashMap = this.f67015h) == null || hashMap.size() <= 0 || (arrayList = this.f67013f) == null || arrayList.size() <= 0) {
            return;
        }
        if (this.f67012e == null) {
            this.f67012e = new ArrayList<>();
        }
        this.f67012e.clear();
        Iterator<d.a.q0.y0.b.a> it = this.f67013f.iterator();
        while (it.hasNext()) {
            d.a.q0.y0.b.a next = it.next();
            if (next != null && !StringUtils.isNull(next.b())) {
                d.a.q0.y0.b.c cVar = new d.a.q0.y0.b.c();
                cVar.c(next.a());
                cVar.d(next.b());
                ArrayList<j0> arrayList2 = this.f67015h.get(Integer.valueOf(next.a()));
                if (arrayList2 != null) {
                    cVar.e(arrayList2);
                }
                this.f67012e.add(cVar);
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
