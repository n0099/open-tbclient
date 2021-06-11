package d.a.n0.p2.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f61843a;

    /* renamed from: b  reason: collision with root package name */
    public String f61844b;

    /* renamed from: c  reason: collision with root package name */
    public b f61845c;

    /* renamed from: d  reason: collision with root package name */
    public MetaData f61846d;

    public String a() {
        return this.f61844b;
    }

    public String b() {
        return this.f61843a;
    }

    public b c() {
        return this.f61845c;
    }

    public MetaData d() {
        return this.f61846d;
    }

    public void e(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f61843a = dataRes.publish_user;
        this.f61844b = dataRes.publish_pic;
        MetaData metaData = new MetaData();
        this.f61846d = metaData;
        metaData.parserProtobuf(dataRes.author);
        this.f61846d.setPendantData(null);
        b bVar = new b();
        this.f61845c = bVar;
        bVar.e(TbadkCoreApplication.getInst(), dataRes.thread_info);
    }
}
