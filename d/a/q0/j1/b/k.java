package d.a.q0.j1.b;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import d.a.p0.s.q.a1;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ReplyMe.DataRes;
import tbclient.ReplyMe.ReplyList;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes8.dex */
public class k implements d.a.p0.i0.b.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<FeedData> f59631e;

    /* renamed from: f  reason: collision with root package name */
    public a1 f59632f;

    /* renamed from: g  reason: collision with root package name */
    public i f59633g;

    public k() {
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
        this.f59631e = new ArrayList<>();
        this.f59632f = new a1();
        this.f59633g = new i();
    }

    public ArrayList<FeedData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59631e : (ArrayList) invokeV.objValue;
    }

    public a1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59632f : (a1) invokeV.objValue;
    }

    @Override // d.a.p0.i0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
                if (optJSONArray == null) {
                    optJSONArray = jSONObject.optJSONArray("at_list");
                }
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        FeedData feedData = new FeedData();
                        feedData.parserJson(optJSONArray.optJSONObject(i2));
                        this.f59631e.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && ListUtils.getCount(feedData.getPraiseList()) == 0) {
                            this.f59631e.remove(feedData);
                        }
                    }
                }
                this.f59633g.f(jSONObject.optJSONObject("message"));
                this.f59632f.i(jSONObject.optJSONObject("page"));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    @Override // d.a.p0.i0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, message) == null) && (message instanceof ReplyMeResIdl)) {
            DataRes dataRes = ((ReplyMeResIdl) message).data;
            try {
                List<ReplyList> list = dataRes.reply_list;
                if (list != null) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        FeedData feedData = new FeedData();
                        feedData.parserProtoBuf(list.get(i2));
                        this.f59631e.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && ListUtils.getCount(feedData.getPraiseList()) == 0) {
                            this.f59631e.remove(feedData);
                        }
                    }
                }
                this.f59632f.j(dataRes.page);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
