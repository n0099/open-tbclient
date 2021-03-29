package d.b.i0.y.a.c;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class d implements d.b.h0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f62555e;

    /* renamed from: f  reason: collision with root package name */
    public int f62556f;

    /* renamed from: g  reason: collision with root package name */
    public String f62557g;

    /* renamed from: h  reason: collision with root package name */
    public String f62558h;
    public String i;

    public d(int i, tinfo tinfoVar) {
        if (tinfoVar == null) {
            return;
        }
        this.f62555e = new ArrayList<>();
        this.f62556f = i;
        this.f62558h = String.valueOf(tinfoVar.forum_id);
        this.f62557g = tinfoVar.forum_name;
        this.i = String.valueOf(tinfoVar.thread_id);
        for (Pic pic : tinfoVar.pics) {
            if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                this.f62555e.add(pic.big_pic);
            }
        }
    }

    public CustomMessage<ImageViewerConfig> b(Context context) {
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(this.f62555e);
        bVar.B(this.f62556f);
        bVar.z(this.f62557g);
        bVar.y(this.f62558h);
        bVar.P(this.i);
        bVar.C(true);
        bVar.G(false);
        ArrayList<String> arrayList = this.f62555e;
        bVar.K(arrayList.get(arrayList.size() - 1));
        return new CustomMessage<>(2010000, bVar.v(context));
    }
}
