package d.a.j0.f1.b;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.squareup.wire.Message;
import d.a.i0.r.q.z0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ReplyMe.DataRes;
import tbclient.ReplyMe.ReplyList;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes4.dex */
public class k implements d.a.i0.g0.b.h {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<FeedData> f54175e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public z0 f54176f = new z0();

    /* renamed from: g  reason: collision with root package name */
    public i f54177g = new i();

    public ArrayList<FeedData> a() {
        return this.f54175e;
    }

    public z0 b() {
        return this.f54176f;
    }

    @Override // d.a.i0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            if (optJSONArray == null) {
                optJSONArray = jSONObject.optJSONArray("at_list");
            }
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray.optJSONObject(i2));
                    this.f54175e.add(feedData);
                    if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && ListUtils.getCount(feedData.getPraiseList()) == 0) {
                        this.f54175e.remove(feedData);
                    }
                }
            }
            this.f54177g.f(jSONObject.optJSONObject("message"));
            this.f54176f.i(jSONObject.optJSONObject("page"));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // d.a.i0.g0.b.h
    public void initByProtobuf(Message message) {
        if (message instanceof ReplyMeResIdl) {
            DataRes dataRes = ((ReplyMeResIdl) message).data;
            try {
                List<ReplyList> list = dataRes.reply_list;
                if (list != null) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        FeedData feedData = new FeedData();
                        feedData.parserProtoBuf(list.get(i2));
                        this.f54175e.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && ListUtils.getCount(feedData.getPraiseList()) == 0) {
                            this.f54175e.remove(feedData);
                        }
                    }
                }
                this.f54176f.j(dataRes.page);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
