package d.a.o0.p2.d;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import tbclient.GetLockWindowMsg.DataRes;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f61968a;

    /* renamed from: b  reason: collision with root package name */
    public String f61969b;

    /* renamed from: c  reason: collision with root package name */
    public b f61970c;

    /* renamed from: d  reason: collision with root package name */
    public MetaData f61971d;

    public String a() {
        return this.f61969b;
    }

    public String b() {
        return this.f61968a;
    }

    public b c() {
        return this.f61970c;
    }

    public MetaData d() {
        return this.f61971d;
    }

    public void e(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f61968a = dataRes.publish_user;
        this.f61969b = dataRes.publish_pic;
        MetaData metaData = new MetaData();
        this.f61971d = metaData;
        metaData.parserProtobuf(dataRes.author);
        this.f61971d.setPendantData(null);
        b bVar = new b();
        this.f61970c = bVar;
        bVar.e(TbadkCoreApplication.getInst(), dataRes.thread_info);
    }
}
