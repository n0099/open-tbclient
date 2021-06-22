package d.a.o0.v2.e;

import d.a.o0.v2.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMoreMsg.DataRes;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f66177a = true;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d> f66178b = null;

    public ArrayList<d> a() {
        return this.f66178b;
    }

    public boolean b() {
        return this.f66177a;
    }

    public void c(DataRes dataRes) {
        if (dataRes != null) {
            this.f66177a = dataRes.has_more.intValue() == 1;
            List<MsgContent> list = dataRes.msg_content;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f66178b = new ArrayList<>();
            for (MsgContent msgContent : dataRes.msg_content) {
                this.f66178b.add(new d(msgContent));
            }
        }
    }
}
