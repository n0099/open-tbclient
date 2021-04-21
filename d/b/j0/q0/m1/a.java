package d.b.j0.q0.m1;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import d.b.c.j.e.n;
import d.b.i0.g0.b.b;
import d.b.i0.g0.b.h;
import d.b.i0.r.q.a2;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import tbclient.StarTrends.DataRes;
import tbclient.StarTrends.StarTrendsResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class a implements b, h {
    public static final Wire i = new Wire(new Class[0]);

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f59933e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, MetaData> f59934f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public boolean f59935g;

    /* renamed from: h  reason: collision with root package name */
    public int f59936h;

    public StarTrendsResIdl b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            StarTrendsResIdl starTrendsResIdl = (StarTrendsResIdl) i.parseFrom(bArr, StarTrendsResIdl.class);
            if (starTrendsResIdl != null && starTrendsResIdl.data != null) {
                c(starTrendsResIdl.data);
            }
            return starTrendsResIdl;
        } catch (Exception e2) {
            BdLog.detailException(e2);
            return null;
        }
    }

    public final void c(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        if (!ListUtils.isEmpty(dataRes.user_list)) {
            for (User user : dataRes.user_list) {
                if (user != null) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(user);
                    String userId = metaData.getUserId();
                    if (userId != null && !"0".equals(userId)) {
                        this.f59934f.put(userId, metaData);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    a2 a2Var = new a2();
                    a2Var.q4(this.f59934f);
                    a2Var.R2(threadInfo);
                    a2Var.V2();
                    a2Var.J1();
                    if (a2Var.getType() == a2.H2 || a2Var.getType() == a2.d3 || a2Var.getType() == a2.j3 || a2Var.getType() == a2.e3 || a2Var.getType() == a2.n3 || a2Var.getType() == a2.o3) {
                        this.f59933e.add(a2Var);
                    }
                }
            }
        }
        d.b.i0.b.f.a.d(this.f59933e);
        this.f59935g = dataRes.has_more.intValue() == 1;
    }

    @Override // d.b.i0.g0.b.c
    public String getCacheKey() {
        return null;
    }

    @Override // d.b.i0.g0.b.b
    public boolean initByByteArray(byte[] bArr) {
        return false;
    }

    @Override // d.b.i0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // d.b.i0.g0.b.h
    public void initByProtobuf(Message message) {
    }

    @Override // d.b.i0.g0.b.b
    public byte[] toCacheByteArray() {
        return null;
    }
}
