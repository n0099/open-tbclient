package d.a.o0.e3.h0;

import java.util.ArrayList;
import java.util.List;
import tbclient.ActHot;
import tbclient.ActPost;
import tbclient.LinkInfo;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f57806a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f57807b = new ArrayList<>();

    public void a(ActPost actPost) {
        if (actPost == null) {
            return;
        }
        String str = actPost.list_head;
        for (ActHot actHot : actPost.act_hot) {
            if (actHot != null) {
                a aVar = new a();
                aVar.g(actHot);
                this.f57806a.add(aVar);
            }
        }
        List<LinkInfo> list = actPost.link_info;
        for (LinkInfo linkInfo : list) {
            if (list != null) {
                b bVar = new b();
                bVar.a(linkInfo);
                this.f57807b.add(bVar);
            }
        }
    }
}
