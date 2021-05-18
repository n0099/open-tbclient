package d.a.k0.o2.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f58043a;

    /* renamed from: b  reason: collision with root package name */
    public String f58044b;

    /* renamed from: c  reason: collision with root package name */
    public b f58045c;

    /* renamed from: d  reason: collision with root package name */
    public MetaData f58046d;

    public String a() {
        return this.f58044b;
    }

    public String b() {
        return this.f58043a;
    }

    public b c() {
        return this.f58045c;
    }

    public MetaData d() {
        return this.f58046d;
    }

    public void e(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f58043a = dataRes.publish_user;
        this.f58044b = dataRes.publish_pic;
        MetaData metaData = new MetaData();
        this.f58046d = metaData;
        metaData.parserProtobuf(dataRes.author);
        this.f58046d.setPendantData(null);
        b bVar = new b();
        this.f58045c = bVar;
        bVar.e(TbadkCoreApplication.getInst(), dataRes.thread_info);
    }
}
