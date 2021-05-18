package d.a.k0.u2.e;

import d.a.k0.u2.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMoreMsg.DataRes;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f62180a = true;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d> f62181b = null;

    public ArrayList<d> a() {
        return this.f62181b;
    }

    public boolean b() {
        return this.f62180a;
    }

    public void c(DataRes dataRes) {
        if (dataRes != null) {
            this.f62180a = dataRes.has_more.intValue() == 1;
            List<MsgContent> list = dataRes.msg_content;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f62181b = new ArrayList<>();
            for (MsgContent msgContent : dataRes.msg_content) {
                this.f62181b.add(new d(msgContent));
            }
        }
    }
}
