package d.b.i0.o2.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f58848a;

    /* renamed from: b  reason: collision with root package name */
    public String f58849b;

    /* renamed from: c  reason: collision with root package name */
    public b f58850c;

    /* renamed from: d  reason: collision with root package name */
    public MetaData f58851d;

    public String a() {
        return this.f58849b;
    }

    public String b() {
        return this.f58848a;
    }

    public b c() {
        return this.f58850c;
    }

    public MetaData d() {
        return this.f58851d;
    }

    public void e(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f58848a = dataRes.publish_user;
        this.f58849b = dataRes.publish_pic;
        MetaData metaData = new MetaData();
        this.f58851d = metaData;
        metaData.parserProtobuf(dataRes.author);
        this.f58851d.setPendantData(null);
        b bVar = new b();
        this.f58850c = bVar;
        bVar.e(TbadkCoreApplication.getInst(), dataRes.thread_info);
    }
}
