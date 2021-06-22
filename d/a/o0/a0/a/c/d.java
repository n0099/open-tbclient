package d.a.o0.a0.a.c;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class d implements d.a.n0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f54936e;

    /* renamed from: f  reason: collision with root package name */
    public int f54937f;

    /* renamed from: g  reason: collision with root package name */
    public String f54938g;

    /* renamed from: h  reason: collision with root package name */
    public String f54939h;

    /* renamed from: i  reason: collision with root package name */
    public String f54940i;

    public d(int i2, tinfo tinfoVar) {
        if (tinfoVar == null) {
            return;
        }
        this.f54936e = new ArrayList<>();
        this.f54937f = i2;
        this.f54939h = String.valueOf(tinfoVar.forum_id);
        this.f54938g = tinfoVar.forum_name;
        this.f54940i = String.valueOf(tinfoVar.thread_id);
        for (Pic pic : tinfoVar.pics) {
            if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                this.f54936e.add(pic.big_pic);
            }
        }
    }

    public CustomMessage<ImageViewerConfig> a(Context context) {
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(this.f54936e);
        bVar.B(this.f54937f);
        bVar.z(this.f54938g);
        bVar.y(this.f54939h);
        bVar.O(this.f54940i);
        bVar.C(true);
        bVar.F(false);
        ArrayList<String> arrayList = this.f54936e;
        bVar.J(arrayList.get(arrayList.size() - 1));
        return new CustomMessage<>(2010000, bVar.v(context));
    }
}
