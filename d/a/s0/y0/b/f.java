package d.a.s0.y0.b;

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
import d.a.r0.r.q.j0;
import d.a.r0.r.q.k0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.a.f<GiftTabActivity> f69527a;

    /* renamed from: b  reason: collision with root package name */
    public DefaultGiftListModel f69528b;

    /* renamed from: c  reason: collision with root package name */
    public CategoryGiftListModel f69529c;

    /* renamed from: d  reason: collision with root package name */
    public FreeGiftChanceModel f69530d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.s0.y0.b.c> f69531e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.a.s0.y0.b.a> f69532f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.a.s0.y0.b.e> f69533g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<Integer, ArrayList<j0>> f69534h;

    /* renamed from: i  reason: collision with root package name */
    public int f69535i;
    public String j;
    public int k;
    public k0 l;
    public e m;
    public d n;
    public DefaultGiftListModel.b o;
    public CategoryGiftListModel.b p;
    public FreeGiftChanceModel.b q;

    /* loaded from: classes9.dex */
    public class a implements DefaultGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f69536a;

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
            this.f69536a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.b
        public void a(int i2, String str, int i3, String str2, int i4, k0 k0Var, ArrayList<d.a.s0.y0.b.a> arrayList, ArrayList<j0> arrayList2, ArrayList<d.a.s0.y0.b.e> arrayList3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Integer.valueOf(i4), k0Var, arrayList, arrayList2, arrayList3}) == null) {
                if (i2 == 0) {
                    int i5 = 0;
                    if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                        i5 = arrayList.get(0).a();
                    }
                    this.f69536a.f69532f = arrayList;
                    this.f69536a.f69534h.put(Integer.valueOf(i5), arrayList2);
                    this.f69536a.f69533g = arrayList3;
                    this.f69536a.j = str2;
                    this.f69536a.f69535i = i3;
                    f fVar = this.f69536a;
                    fVar.k = i4;
                    fVar.l = k0Var;
                    fVar.q();
                }
                if (this.f69536a.m != null) {
                    e eVar = this.f69536a.m;
                    String str3 = this.f69536a.j;
                    f fVar2 = this.f69536a;
                    eVar.a(i2, str, true, str3, fVar2.k, fVar2.l, fVar2.f69531e, this.f69536a.f69532f, this.f69536a.f69533g);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements CategoryGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f69537a;

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
            this.f69537a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.b
        public void a(int i2, String str, int i3, ArrayList<j0> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), arrayList}) == null) {
                if (i2 == 0) {
                    this.f69537a.f69534h.put(Integer.valueOf(i3), arrayList);
                    this.f69537a.q();
                }
                if (this.f69537a.m != null) {
                    e eVar = this.f69537a.m;
                    String str2 = this.f69537a.j;
                    f fVar = this.f69537a;
                    eVar.a(i2, str, false, str2, fVar.k, fVar.l, fVar.f69531e, this.f69537a.f69532f, this.f69537a.f69533g);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements FreeGiftChanceModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f69538a;

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
            this.f69538a = fVar;
        }

        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.b
        public void a(int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) && i2 == 0) {
                this.f69538a.f69535i = i3;
                if (this.f69538a.n != null) {
                    this.f69538a.n.a(this.f69538a.f69535i);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a(int i2);
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a(int i2, String str, boolean z, String str2, int i3, k0 k0Var, ArrayList<d.a.s0.y0.b.c> arrayList, ArrayList<d.a.s0.y0.b.a> arrayList2, ArrayList<d.a.s0.y0.b.e> arrayList3);
    }

    public f(d.a.c.a.f<GiftTabActivity> fVar) {
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
        this.f69534h = new HashMap<>();
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.f69527a = fVar;
        DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(fVar);
        this.f69528b = defaultGiftListModel;
        defaultGiftListModel.I(this.o);
        CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f69527a);
        this.f69529c = categoryGiftListModel;
        categoryGiftListModel.A(this.p);
        FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f69527a);
        this.f69530d = freeGiftChanceModel;
        freeGiftChanceModel.A(this.q);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.f69530d == null) {
                FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.f69527a);
                this.f69530d = freeGiftChanceModel;
                freeGiftChanceModel.A(this.q);
            }
            this.f69530d.z(str);
        }
    }

    public void o(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            if (this.f69528b == null) {
                DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(this.f69527a);
                this.f69528b = defaultGiftListModel;
                defaultGiftListModel.I(this.o);
            }
            this.f69528b.H(str, j);
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f69529c == null) {
                CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.f69527a);
                this.f69529c = categoryGiftListModel;
                categoryGiftListModel.A(this.p);
            }
            this.f69529c.z(i2);
        }
    }

    public final void q() {
        HashMap<Integer, ArrayList<j0>> hashMap;
        ArrayList<d.a.s0.y0.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hashMap = this.f69534h) == null || hashMap.size() <= 0 || (arrayList = this.f69532f) == null || arrayList.size() <= 0) {
            return;
        }
        if (this.f69531e == null) {
            this.f69531e = new ArrayList<>();
        }
        this.f69531e.clear();
        Iterator<d.a.s0.y0.b.a> it = this.f69532f.iterator();
        while (it.hasNext()) {
            d.a.s0.y0.b.a next = it.next();
            if (next != null && !StringUtils.isNull(next.b())) {
                d.a.s0.y0.b.c cVar = new d.a.s0.y0.b.c();
                cVar.c(next.a());
                cVar.d(next.b());
                ArrayList<j0> arrayList2 = this.f69534h.get(Integer.valueOf(next.a()));
                if (arrayList2 != null) {
                    cVar.e(arrayList2);
                }
                this.f69531e.add(cVar);
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
