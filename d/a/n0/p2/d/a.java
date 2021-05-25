package d.a.n0.p2.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f58152a;

    /* renamed from: b  reason: collision with root package name */
    public String f58153b;

    /* renamed from: c  reason: collision with root package name */
    public b f58154c;

    /* renamed from: d  reason: collision with root package name */
    public MetaData f58155d;

    public String a() {
        return this.f58153b;
    }

    public String b() {
        return this.f58152a;
    }

    public b c() {
        return this.f58154c;
    }

    public MetaData d() {
        return this.f58155d;
    }

    public void e(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f58152a = dataRes.publish_user;
        this.f58153b = dataRes.publish_pic;
        MetaData metaData = new MetaData();
        this.f58155d = metaData;
        metaData.parserProtobuf(dataRes.author);
        this.f58155d.setPendantData(null);
        b bVar = new b();
        this.f58154c = bVar;
        bVar.e(TbadkCoreApplication.getInst(), dataRes.thread_info);
    }
}
