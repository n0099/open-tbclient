package d.b.j0.y.a.c;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class d implements d.b.i0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f64421e;

    /* renamed from: f  reason: collision with root package name */
    public int f64422f;

    /* renamed from: g  reason: collision with root package name */
    public String f64423g;

    /* renamed from: h  reason: collision with root package name */
    public String f64424h;
    public String i;

    public d(int i, tinfo tinfoVar) {
        if (tinfoVar == null) {
            return;
        }
        this.f64421e = new ArrayList<>();
        this.f64422f = i;
        this.f64424h = String.valueOf(tinfoVar.forum_id);
        this.f64423g = tinfoVar.forum_name;
        this.i = String.valueOf(tinfoVar.thread_id);
        for (Pic pic : tinfoVar.pics) {
            if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                this.f64421e.add(pic.big_pic);
            }
        }
    }

    public CustomMessage<ImageViewerConfig> b(Context context) {
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(this.f64421e);
        bVar.B(this.f64422f);
        bVar.z(this.f64423g);
        bVar.y(this.f64424h);
        bVar.P(this.i);
        bVar.C(true);
        bVar.G(false);
        ArrayList<String> arrayList = this.f64421e;
        bVar.K(arrayList.get(arrayList.size() - 1));
        return new CustomMessage<>(2010000, bVar.v(context));
    }
}
