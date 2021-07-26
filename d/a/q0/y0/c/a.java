package d.a.q0.y0.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.k0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
import tbclient.GetMyGift.presentMoneyTxt;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f67020a;

    /* renamed from: b  reason: collision with root package name */
    public long f67021b;

    /* renamed from: c  reason: collision with root package name */
    public b f67022c;

    /* renamed from: d  reason: collision with root package name */
    public c f67023d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1856a> f67024e;

    /* renamed from: f  reason: collision with root package name */
    public long f67025f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f67026g;

    /* renamed from: h  reason: collision with root package name */
    public int f67027h;

    /* renamed from: d.a.q0.y0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1856a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f67028a;

        /* renamed from: b  reason: collision with root package name */
        public String f67029b;

        /* renamed from: c  reason: collision with root package name */
        public String f67030c;

        /* renamed from: d  reason: collision with root package name */
        public String f67031d;

        /* renamed from: e  reason: collision with root package name */
        public long f67032e;

        /* renamed from: f  reason: collision with root package name */
        public long f67033f;

        /* renamed from: g  reason: collision with root package name */
        public long f67034g;

        /* renamed from: h  reason: collision with root package name */
        public int f67035h;

        /* renamed from: i  reason: collision with root package name */
        public String f67036i;
        public int j;
        public String k;

        public C1856a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f67037a;

        /* renamed from: b  reason: collision with root package name */
        public int f67038b;

        /* renamed from: c  reason: collision with root package name */
        public int f67039c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f67040a;

        /* renamed from: b  reason: collision with root package name */
        public String f67041b;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public ArrayList<C1856a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67024e : (ArrayList) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67020a : invokeV.longValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67022c : (b) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67023d : (c) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67021b : invokeV.longValue;
    }

    public void f(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f67020a = dataRes.total_num.intValue();
        this.f67021b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f67025f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            k0 k0Var = new k0();
            this.f67026g = k0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                k0Var.f53374a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f67026g.f53375b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f67022c = bVar;
            bVar.f67037a = dataRes.page.cur_page.intValue();
            this.f67022c.f67038b = dataRes.page.has_more.intValue();
            this.f67022c.f67039c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f67023d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f67040a = presentmoneytxt.txt;
            cVar.f67041b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f67024e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C1856a c1856a = new C1856a();
                    c1856a.j = i2 + 1;
                    c1856a.f67028a = presentMyList.pay_userid.longValue();
                    c1856a.f67029b = presentMyList.pay_username;
                    c1856a.f67030c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c1856a.f67031d = presentMyList.thumbnail_url;
                    c1856a.f67032e = presentMyList.create_time.intValue();
                    c1856a.f67033f = presentMyList.num.intValue();
                    c1856a.f67035h = presentMyList.currency_unit.intValue();
                    c1856a.f67036i = presentMyList.currency_type;
                    c1856a.f67034g = presentMyList.present_scores.longValue();
                    c1856a.k = presentMyList.name_show;
                    this.f67024e.add(c1856a);
                }
            }
        }
        this.f67027h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C1856a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f67024e = arrayList;
        }
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f67020a = j;
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f67022c = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f67023d = cVar;
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.f67021b = j;
        }
    }
}
