package d.a.j0.o2.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f57301a;

    /* renamed from: b  reason: collision with root package name */
    public String f57302b;

    /* renamed from: c  reason: collision with root package name */
    public b f57303c;

    /* renamed from: d  reason: collision with root package name */
    public MetaData f57304d;

    public String a() {
        return this.f57302b;
    }

    public String b() {
        return this.f57301a;
    }

    public b c() {
        return this.f57303c;
    }

    public MetaData d() {
        return this.f57304d;
    }

    public void e(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f57301a = dataRes.publish_user;
        this.f57302b = dataRes.publish_pic;
        MetaData metaData = new MetaData();
        this.f57304d = metaData;
        metaData.parserProtobuf(dataRes.author);
        this.f57304d.setPendantData(null);
        b bVar = new b();
        this.f57303c = bVar;
        bVar.e(TbadkCoreApplication.getInst(), dataRes.thread_info);
    }
}
