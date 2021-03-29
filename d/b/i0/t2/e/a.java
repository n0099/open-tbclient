package d.b.i0.t2.e;

import d.b.i0.t2.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMoreMsg.DataRes;
import tbclient.GetMoreMsg.MsgContent;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f61126a = true;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<d> f61127b = null;

    public ArrayList<d> a() {
        return this.f61127b;
    }

    public boolean b() {
        return this.f61126a;
    }

    public void c(DataRes dataRes) {
        if (dataRes != null) {
            this.f61126a = dataRes.has_more.intValue() == 1;
            List<MsgContent> list = dataRes.msg_content;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.f61127b = new ArrayList<>();
            for (MsgContent msgContent : dataRes.msg_content) {
                this.f61127b.add(new d(msgContent));
            }
        }
    }
}
