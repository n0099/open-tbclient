package d.b.j0.o2.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f59269a;

    /* renamed from: b  reason: collision with root package name */
    public String f59270b;

    /* renamed from: c  reason: collision with root package name */
    public b f59271c;

    /* renamed from: d  reason: collision with root package name */
    public MetaData f59272d;

    public String a() {
        return this.f59270b;
    }

    public String b() {
        return this.f59269a;
    }

    public b c() {
        return this.f59271c;
    }

    public MetaData d() {
        return this.f59272d;
    }

    public void e(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f59269a = dataRes.publish_user;
        this.f59270b = dataRes.publish_pic;
        MetaData metaData = new MetaData();
        this.f59272d = metaData;
        metaData.parserProtobuf(dataRes.author);
        this.f59272d.setPendantData(null);
        b bVar = new b();
        this.f59271c = bVar;
        bVar.e(TbadkCoreApplication.getInst(), dataRes.thread_info);
    }
}
