package d.a.q0.n1;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.p0.b1.f0;
import d.a.p0.b1.i0;
import d.a.p0.b1.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f61114a;

    /* renamed from: b  reason: collision with root package name */
    public final List<ICardInfo> f61115b;

    /* renamed from: c  reason: collision with root package name */
    public int f61116c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61117d;

    /* renamed from: e  reason: collision with root package name */
    public String f61118e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61119f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61120g;

    /* renamed from: h  reason: collision with root package name */
    public final BdListView f61121h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.q0.n1.n.a f61122i;
    public long j;
    public String k;

    /* loaded from: classes8.dex */
    public class a extends f0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.d.e.d.l f61123a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f61124b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f61125c;

        public a(h hVar, d.a.d.e.d.l lVar, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, lVar, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61123a = lVar;
            this.f61124b = j;
            this.f61125c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.f0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.d.e.d.l lVar = this.f61123a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f61124b);
                sb.append("_");
                sb.append(TextUtils.isEmpty(this.f61125c) ? "" : this.f61125c);
                byte[] bArr = (byte[]) lVar.get(sb.toString());
                if (bArr != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException e2) {
                        BdLog.e(e2);
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements n<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f61126a;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61126a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f61126a.h(dataRes);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(List<d.a.q0.n1.p.d> list);

        void b(long j, String str);

        void c(int i2, String str);

        void d(String str, String str2, String str3, List<d.a.q0.n1.p.e> list);

        void onError(int i2, String str);

        void onSuccess();
    }

    public h(BdListView bdListView, d.a.q0.n1.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdListView, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61114a = null;
        this.f61115b = new LinkedList();
        this.f61116c = 1;
        this.f61118e = "";
        this.f61119f = false;
        this.f61120g = false;
        this.f61121h = bdListView;
        this.f61122i = aVar;
    }

    public List<ICardInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61115b : (List) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61117d : invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61119f : invokeV.booleanValue;
    }

    public final void e(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048579, this, j, str) == null) {
            i0.b(new a(this, d.a.p0.s.r.a.f().d("tb.lego_update"), j, str), new b(this));
        }
    }

    public final void f(long j, String str) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048580, this, j, str) == null) || (cVar = this.f61114a) == null) {
            return;
        }
        cVar.b(j, str);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || d() || this.f61114a == null) {
            return;
        }
        this.f61116c++;
        k(true);
        this.f61114a.c(this.f61116c, this.f61118e);
    }

    public final void h(DataRes dataRes) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dataRes) == null) {
            this.f61120g = true;
            if (dataRes != null) {
                if (j(true, dataRes) && (cVar = this.f61114a) != null) {
                    cVar.onSuccess();
                }
                f(this.j, this.k);
                return;
            }
            f(this.j, this.k);
        }
    }

    public void i(boolean z, DataRes dataRes, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), dataRes, Integer.valueOf(i2), str}) == null) {
            k(false);
            if (z) {
                this.f61121h.z();
            }
            if (i2 == 0 && dataRes != null && j(z, dataRes)) {
                c cVar = this.f61114a;
                if (cVar != null) {
                    cVar.onSuccess();
                }
                if (z) {
                    n(dataRes);
                }
            } else if (this.f61115b.size() > 0) {
                c cVar2 = this.f61114a;
                if (cVar2 != null) {
                    cVar2.onError(1, str);
                }
            } else {
                c cVar3 = this.f61114a;
                if (cVar3 != null) {
                    cVar3.onError(2, str);
                }
            }
        }
    }

    public final boolean j(boolean z, DataRes dataRes) {
        InterceptResult invokeZL;
        String str;
        String str2;
        String str3;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, dataRes)) == null) {
            if (dataRes == null) {
                return false;
            }
            if (z) {
                this.f61115b.clear();
            }
            this.f61117d = dataRes.has_more.intValue() == 1;
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject3 = new JSONObject(dataRes.page_info);
                JSONArray optJSONArray = jSONObject3.optJSONArray("tab");
                JSONObject optJSONObject = jSONObject3.optJSONObject("title");
                if (optJSONObject != null) {
                    str2 = optJSONObject.optString("name");
                    str3 = optJSONObject.optString("url");
                    str = optJSONObject.optString("urlNight");
                } else {
                    str = "";
                    str2 = str;
                    str3 = str2;
                }
                if (optJSONArray != null) {
                    int i2 = 0;
                    while (i2 < optJSONArray.length()) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            d.a.q0.n1.p.e eVar = new d.a.q0.n1.p.e();
                            eVar.f61285c = optJSONObject2.optString("title");
                            jSONObject2 = jSONObject3;
                            eVar.f61283a = optJSONObject2.optLong("page_id");
                            optJSONObject2.optInt("page_type");
                            eVar.f61286d = optJSONObject2.optInt("rn");
                            eVar.f61284b = optJSONObject2.optString("item_id");
                            eVar.f61287e = optJSONObject2.optString("params");
                            eVar.b();
                            arrayList.add(eVar);
                        } else {
                            jSONObject2 = jSONObject3;
                        }
                        i2++;
                        jSONObject3 = jSONObject2;
                    }
                    jSONObject = jSONObject3;
                    this.f61114a.d(str2, str3, str, arrayList);
                } else {
                    jSONObject = jSONObject3;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("buttons");
                if (optJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                        if (optJSONObject3 != null) {
                            d.a.q0.n1.p.d dVar = new d.a.q0.n1.p.d();
                            dVar.b(optJSONObject3);
                            if (dVar.a()) {
                                arrayList2.add(dVar);
                            }
                        }
                    }
                    this.f61114a.a(arrayList2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (dataRes.cards != null) {
                for (int i4 = 0; i4 < dataRes.cards.size(); i4++) {
                    ICardInfo i5 = d.a.q0.n1.o.b.i(dataRes.cards.get(i4));
                    if (i5 != null && i5.isValid()) {
                        this.f61115b.add(i5);
                    }
                }
            }
            if (this.f61115b.size() == 0) {
                return false;
            }
            try {
                this.f61118e = this.f61115b.get(this.f61115b.size() - 1).getFlipId();
            } catch (Exception unused) {
                this.f61118e = "";
            }
            this.f61122i.C(this.f61115b);
            return true;
        }
        return invokeZL.booleanValue;
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f61119f = z;
        }
    }

    public void l(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.f61114a = cVar;
        }
    }

    public void m(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048587, this, j, str) == null) {
            this.f61116c = 1;
            this.j = j;
            this.k = str;
            if (this.f61115b.size() == 0 && !this.f61120g) {
                e(j, str);
            } else {
                f(j, str);
            }
        }
    }

    public final void n(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, dataRes) == null) || dataRes == null) {
            return;
        }
        d.a.d.e.d.l<byte[]> d2 = d.a.p0.s.r.a.f().d("tb.lego_update");
        StringBuilder sb = new StringBuilder();
        sb.append(this.j);
        sb.append("_");
        sb.append(TextUtils.isEmpty(this.k) ? "" : this.k);
        d2.a(sb.toString(), dataRes.toByteArray());
    }
}
