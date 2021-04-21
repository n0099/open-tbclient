package d.b.j0.u2.e;

import d.b.j0.u2.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMoreMsg.DataRes;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f63236a = true;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d> f63237b = null;

    public ArrayList<d> a() {
        return this.f63237b;
    }

    public boolean b() {
        return this.f63236a;
    }

    public void c(DataRes dataRes) {
        if (dataRes != null) {
            this.f63236a = dataRes.has_more.intValue() == 1;
            List<MsgContent> list = dataRes.msg_content;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f63237b = new ArrayList<>();
            for (MsgContent msgContent : dataRes.msg_content) {
                this.f63237b.add(new d(msgContent));
            }
        }
    }
}
