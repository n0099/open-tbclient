package d.a.s0.y0.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.k0;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
import tbclient.GetMyGift.presentMoneyTxt;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f69539a;

    /* renamed from: b  reason: collision with root package name */
    public long f69540b;

    /* renamed from: c  reason: collision with root package name */
    public b f69541c;

    /* renamed from: d  reason: collision with root package name */
    public c f69542d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1892a> f69543e;

    /* renamed from: f  reason: collision with root package name */
    public long f69544f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f69545g;

    /* renamed from: h  reason: collision with root package name */
    public int f69546h;

    /* renamed from: d.a.s0.y0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1892a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f69547a;

        /* renamed from: b  reason: collision with root package name */
        public String f69548b;

        /* renamed from: c  reason: collision with root package name */
        public String f69549c;

        /* renamed from: d  reason: collision with root package name */
        public String f69550d;

        /* renamed from: e  reason: collision with root package name */
        public long f69551e;

        /* renamed from: f  reason: collision with root package name */
        public long f69552f;

        /* renamed from: g  reason: collision with root package name */
        public long f69553g;

        /* renamed from: h  reason: collision with root package name */
        public int f69554h;

        /* renamed from: i  reason: collision with root package name */
        public String f69555i;
        public int j;
        public String k;

        public C1892a() {
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

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f69556a;

        /* renamed from: b  reason: collision with root package name */
        public int f69557b;

        /* renamed from: c  reason: collision with root package name */
        public int f69558c;

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

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f69559a;

        /* renamed from: b  reason: collision with root package name */
        public String f69560b;

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

    public ArrayList<C1892a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69543e : (ArrayList) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69539a : invokeV.longValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69541c : (b) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f69542d : (c) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f69540b : invokeV.longValue;
    }

    public void f(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f69539a = dataRes.total_num.intValue();
        this.f69540b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f69544f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            k0 k0Var = new k0();
            this.f69545g = k0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                k0Var.f55994a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f69545g.f55995b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f69541c = bVar;
            bVar.f69556a = dataRes.page.cur_page.intValue();
            this.f69541c.f69557b = dataRes.page.has_more.intValue();
            this.f69541c.f69558c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f69542d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f69559a = presentmoneytxt.txt;
            cVar.f69560b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f69543e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C1892a c1892a = new C1892a();
                    c1892a.j = i2 + 1;
                    c1892a.f69547a = presentMyList.pay_userid.longValue();
                    c1892a.f69548b = presentMyList.pay_username;
                    c1892a.f69549c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c1892a.f69550d = presentMyList.thumbnail_url;
                    c1892a.f69551e = presentMyList.create_time.intValue();
                    c1892a.f69552f = presentMyList.num.intValue();
                    c1892a.f69554h = presentMyList.currency_unit.intValue();
                    c1892a.f69555i = presentMyList.currency_type;
                    c1892a.f69553g = presentMyList.present_scores.longValue();
                    c1892a.k = presentMyList.name_show;
                    this.f69543e.add(c1892a);
                }
            }
        }
        this.f69546h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C1892a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f69543e = arrayList;
        }
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f69539a = j;
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f69541c = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f69542d = cVar;
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.f69540b = j;
        }
    }
}
