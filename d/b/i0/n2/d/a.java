package d.b.i0.n2.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f57148a;

    /* renamed from: b  reason: collision with root package name */
    public String f57149b;

    /* renamed from: c  reason: collision with root package name */
    public b f57150c;

    /* renamed from: d  reason: collision with root package name */
    public MetaData f57151d;

    public String a() {
        return this.f57149b;
    }

    public String b() {
        return this.f57148a;
    }

    public b c() {
        return this.f57150c;
    }

    public MetaData d() {
        return this.f57151d;
    }

    public void e(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f57148a = dataRes.publish_user;
        this.f57149b = dataRes.publish_pic;
        MetaData metaData = new MetaData();
        this.f57151d = metaData;
        metaData.parserProtobuf(dataRes.author);
        this.f57151d.setPendantData(null);
        b bVar = new b();
        this.f57150c = bVar;
        bVar.e(TbadkCoreApplication.getInst(), dataRes.thread_info);
    }
}
