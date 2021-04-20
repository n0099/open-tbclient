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
    public ArrayList<String> f64000e;

    /* renamed from: f  reason: collision with root package name */
    public int f64001f;

    /* renamed from: g  reason: collision with root package name */
    public String f64002g;

    /* renamed from: h  reason: collision with root package name */
    public String f64003h;
    public String i;

    public d(int i, tinfo tinfoVar) {
        if (tinfoVar == null) {
            return;
        }
        this.f64000e = new ArrayList<>();
        this.f64001f = i;
        this.f64003h = String.valueOf(tinfoVar.forum_id);
        this.f64002g = tinfoVar.forum_name;
        this.i = String.valueOf(tinfoVar.thread_id);
        for (Pic pic : tinfoVar.pics) {
            if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                this.f64000e.add(pic.big_pic);
            }
        }
    }

    public CustomMessage<ImageViewerConfig> b(Context context) {
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(this.f64000e);
        bVar.B(this.f64001f);
        bVar.z(this.f64002g);
        bVar.y(this.f64003h);
        bVar.P(this.i);
        bVar.C(true);
        bVar.G(false);
        ArrayList<String> arrayList = this.f64000e;
        bVar.K(arrayList.get(arrayList.size() - 1));
        return new CustomMessage<>(2010000, bVar.v(context));
    }
}
