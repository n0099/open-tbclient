package d.a.k0.q0.m1;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import d.a.c.j.e.n;
import d.a.j0.g0.b.b;
import d.a.j0.g0.b.h;
import d.a.j0.r.q.a2;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import tbclient.StarTrends.DataRes;
import tbclient.StarTrends.StarTrendsResIdl;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class a implements b, h {

    /* renamed from: i  reason: collision with root package name */
    public static final Wire f58752i = new Wire(new Class[0]);

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f58753e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, MetaData> f58754f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public boolean f58755g;

    /* renamed from: h  reason: collision with root package name */
    public int f58756h;

    public StarTrendsResIdl a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            StarTrendsResIdl starTrendsResIdl = (StarTrendsResIdl) f58752i.parseFrom(bArr, StarTrendsResIdl.class);
            if (starTrendsResIdl != null && starTrendsResIdl.data != null) {
                b(starTrendsResIdl.data);
            }
            return starTrendsResIdl;
        } catch (Exception e2) {
            BdLog.detailException(e2);
            return null;
        }
    }

    public final void b(DataRes dataRes) {
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
                        this.f58754f.put(userId, metaData);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    a2 a2Var = new a2();
                    a2Var.s4(this.f58754f);
                    a2Var.T2(threadInfo);
                    a2Var.X2();
                    a2Var.K1();
                    if (a2Var.getType() == a2.I2 || a2Var.getType() == a2.e3 || a2Var.getType() == a2.k3 || a2Var.getType() == a2.f3 || a2Var.getType() == a2.o3 || a2Var.getType() == a2.p3) {
                        this.f58753e.add(a2Var);
                    }
                }
            }
        }
        d.a.j0.b.f.a.d(this.f58753e);
        this.f58755g = dataRes.has_more.intValue() == 1;
    }

    @Override // d.a.j0.g0.b.c
    public String getCacheKey() {
        return null;
    }

    @Override // d.a.j0.g0.b.b
    public boolean initByByteArray(byte[] bArr) {
        return false;
    }

    @Override // d.a.j0.g0.b.h
    public void initByJson(JSONObject jSONObject) {
    }

    @Override // d.a.j0.g0.b.h
    public void initByProtobuf(Message message) {
    }

    @Override // d.a.j0.g0.b.b
    public byte[] toCacheByteArray() {
        return null;
    }
}
