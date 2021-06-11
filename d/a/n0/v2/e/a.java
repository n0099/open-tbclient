package d.a.n0.v2.e;

import d.a.n0.v2.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMoreMsg.DataRes;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f66052a = true;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d> f66053b = null;

    public ArrayList<d> a() {
        return this.f66053b;
    }

    public boolean b() {
        return this.f66052a;
    }

    public void c(DataRes dataRes) {
        if (dataRes != null) {
            this.f66052a = dataRes.has_more.intValue() == 1;
            List<MsgContent> list = dataRes.msg_content;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f66053b = new ArrayList<>();
            for (MsgContent msgContent : dataRes.msg_content) {
                this.f66053b.add(new d(msgContent));
            }
        }
    }
}
