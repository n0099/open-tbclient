package d.a.q0.u0.a2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import d.a.d.k.e.n;
import d.a.p0.i0.b.h;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlbumElement;
import tbclient.ItemInfo;
import tbclient.ItemPage.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ItemInfo f63178e;

    /* renamed from: f  reason: collision with root package name */
    public List<AlbumElement> f63179f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f63180g;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63180g = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        ItemInfo itemInfo = dataRes.item_info;
        this.f63178e = itemInfo;
        if (itemInfo == null) {
            return;
        }
        this.f63179f = dataRes.album_list;
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            d.a.q0.u0.a2.g.a aVar = new d.a.q0.u0.a2.g.a();
            aVar.setSupportType(BaseCardInfo.SupportType.TOP);
            this.f63180g.add(aVar);
            int i2 = 1;
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    b2 b2Var = new b2();
                    b2Var.K2(threadInfo);
                    b2Var.O2();
                    b2Var.S3(i2);
                    i2++;
                    b2Var.A1();
                    this.f63180g.add(b2Var);
                    d.a.q0.u0.a2.g.a aVar2 = new d.a.q0.u0.a2.g.a();
                    aVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.f63180g.add(aVar2);
                }
            }
            d.a.q0.u0.a2.g.a aVar3 = new d.a.q0.u0.a2.g.a();
            aVar3.e(this.f63178e.id.intValue());
            aVar3.h(i2);
            aVar3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.f63180g.add(aVar3);
        }
        d.a.q0.u0.a2.g.b bVar = new d.a.q0.u0.a2.g.b();
        bVar.e(dataRes.item_info);
        if (bVar.d()) {
            this.f63180g.add(bVar);
        }
        d.a.q0.u0.a2.g.c cVar = new d.a.q0.u0.a2.g.c();
        cVar.d(dataRes.recommend_item);
        this.f63180g.add(cVar);
    }

    @Override // d.a.p0.i0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // d.a.p0.i0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }
}
