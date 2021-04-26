package d.a.j0.u2.e;

import d.a.j0.u2.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMoreMsg.DataRes;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f61456a = true;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d> f61457b = null;

    public ArrayList<d> a() {
        return this.f61457b;
    }

    public boolean b() {
        return this.f61456a;
    }

    public void c(DataRes dataRes) {
        if (dataRes != null) {
            this.f61456a = dataRes.has_more.intValue() == 1;
            List<MsgContent> list = dataRes.msg_content;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f61457b = new ArrayList<>();
            for (MsgContent msgContent : dataRes.msg_content) {
                this.f61457b.add(new d(msgContent));
            }
        }
    }
}
