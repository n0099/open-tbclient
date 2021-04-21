package d.b.j0.f1.b;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.squareup.wire.Message;
import d.b.i0.r.q.z0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ReplyMe.DataRes;
import tbclient.ReplyMe.ReplyList;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes4.dex */
public class k implements d.b.i0.g0.b.h {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<FeedData> f56293e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public z0 f56294f = new z0();

    /* renamed from: g  reason: collision with root package name */
    public i f56295g = new i();

    public ArrayList<FeedData> b() {
        return this.f56293e;
    }

    public z0 c() {
        return this.f56294f;
    }

    @Override // d.b.i0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            if (optJSONArray == null) {
                optJSONArray = jSONObject.optJSONArray("at_list");
            }
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray.optJSONObject(i));
                    this.f56293e.add(feedData);
                    if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && ListUtils.getCount(feedData.getPraiseList()) == 0) {
                        this.f56293e.remove(feedData);
                    }
                }
            }
            this.f56295g.f(jSONObject.optJSONObject("message"));
            this.f56294f.i(jSONObject.optJSONObject("page"));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // d.b.i0.g0.b.h
    public void initByProtobuf(Message message) {
        if (message instanceof ReplyMeResIdl) {
            DataRes dataRes = ((ReplyMeResIdl) message).data;
            try {
                List<ReplyList> list = dataRes.reply_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        FeedData feedData = new FeedData();
                        feedData.parserProtoBuf(list.get(i));
                        this.f56293e.add(feedData);
                        if ((FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType()) || FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) && ListUtils.getCount(feedData.getPraiseList()) == 0) {
                            this.f56293e.remove(feedData);
                        }
                    }
                }
                this.f56294f.j(dataRes.page);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
