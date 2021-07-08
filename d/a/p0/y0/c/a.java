package d.a.p0.y0.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.k0;
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
    public long f66342a;

    /* renamed from: b  reason: collision with root package name */
    public long f66343b;

    /* renamed from: c  reason: collision with root package name */
    public b f66344c;

    /* renamed from: d  reason: collision with root package name */
    public c f66345d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<C1851a> f66346e;

    /* renamed from: f  reason: collision with root package name */
    public long f66347f;

    /* renamed from: g  reason: collision with root package name */
    public k0 f66348g;

    /* renamed from: h  reason: collision with root package name */
    public int f66349h;

    /* renamed from: d.a.p0.y0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1851a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f66350a;

        /* renamed from: b  reason: collision with root package name */
        public String f66351b;

        /* renamed from: c  reason: collision with root package name */
        public String f66352c;

        /* renamed from: d  reason: collision with root package name */
        public String f66353d;

        /* renamed from: e  reason: collision with root package name */
        public long f66354e;

        /* renamed from: f  reason: collision with root package name */
        public long f66355f;

        /* renamed from: g  reason: collision with root package name */
        public long f66356g;

        /* renamed from: h  reason: collision with root package name */
        public int f66357h;

        /* renamed from: i  reason: collision with root package name */
        public String f66358i;
        public int j;
        public String k;

        public C1851a() {
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
        public int f66359a;

        /* renamed from: b  reason: collision with root package name */
        public int f66360b;

        /* renamed from: c  reason: collision with root package name */
        public int f66361c;

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
        public String f66362a;

        /* renamed from: b  reason: collision with root package name */
        public String f66363b;

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

    public ArrayList<C1851a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66346e : (ArrayList) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66342a : invokeV.longValue;
    }

    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66344c : (b) invokeV.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f66345d : (c) invokeV.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f66343b : invokeV.longValue;
    }

    public void f(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) || dataRes == null) {
            return;
        }
        this.f66342a = dataRes.total_num.intValue();
        this.f66343b = dataRes.money.intValue();
        dataRes.scene_id.intValue();
        this.f66347f = dataRes.blue_diamond.intValue();
        if (dataRes.blue_diamond_txt != null) {
            k0 k0Var = new k0();
            this.f66348g = k0Var;
            String str = dataRes.blue_diamond_txt.txt;
            if (str != null) {
                k0Var.f52710a = str;
            }
            String str2 = dataRes.blue_diamond_txt.url;
            if (str2 != null) {
                this.f66348g.f52711b = str2;
            }
        }
        if (dataRes.page != null) {
            b bVar = new b();
            this.f66344c = bVar;
            bVar.f66359a = dataRes.page.cur_page.intValue();
            this.f66344c.f66360b = dataRes.page.has_more.intValue();
            this.f66344c.f66361c = dataRes.page.total.intValue();
        }
        if (dataRes.money_txt != null) {
            c cVar = new c();
            this.f66345d = cVar;
            presentMoneyTxt presentmoneytxt = dataRes.money_txt;
            cVar.f66362a = presentmoneytxt.txt;
            cVar.f66363b = presentmoneytxt.url;
        }
        List<PresentMyList> list = dataRes.gift_list;
        if (list != null && list.size() > 0) {
            this.f66346e = new ArrayList<>();
            for (int i2 = 0; i2 < dataRes.gift_list.size(); i2++) {
                PresentMyList presentMyList = dataRes.gift_list.get(i2);
                if (presentMyList != null) {
                    C1851a c1851a = new C1851a();
                    c1851a.j = i2 + 1;
                    c1851a.f66350a = presentMyList.pay_userid.longValue();
                    c1851a.f66351b = presentMyList.pay_username;
                    c1851a.f66352c = presentMyList.portrait;
                    presentMyList.gift_id.intValue();
                    String str3 = presentMyList.gift_name;
                    String str4 = presentMyList.play_url;
                    c1851a.f66353d = presentMyList.thumbnail_url;
                    c1851a.f66354e = presentMyList.create_time.intValue();
                    c1851a.f66355f = presentMyList.num.intValue();
                    c1851a.f66357h = presentMyList.currency_unit.intValue();
                    c1851a.f66358i = presentMyList.currency_type;
                    c1851a.f66356g = presentMyList.present_scores.longValue();
                    c1851a.k = presentMyList.name_show;
                    this.f66346e.add(c1851a);
                }
            }
        }
        this.f66349h = dataRes.currency.intValue();
    }

    public void g(ArrayList<C1851a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f66346e = arrayList;
        }
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f66342a = j;
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f66344c = bVar;
        }
    }

    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.f66345d = cVar;
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.f66343b = j;
        }
    }
}
