package d.a.j0.y.a.c;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class d implements d.a.i0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f62694e;

    /* renamed from: f  reason: collision with root package name */
    public int f62695f;

    /* renamed from: g  reason: collision with root package name */
    public String f62696g;

    /* renamed from: h  reason: collision with root package name */
    public String f62697h;

    /* renamed from: i  reason: collision with root package name */
    public String f62698i;

    public d(int i2, tinfo tinfoVar) {
        if (tinfoVar == null) {
            return;
        }
        this.f62694e = new ArrayList<>();
        this.f62695f = i2;
        this.f62697h = String.valueOf(tinfoVar.forum_id);
        this.f62696g = tinfoVar.forum_name;
        this.f62698i = String.valueOf(tinfoVar.thread_id);
        for (Pic pic : tinfoVar.pics) {
            if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                this.f62694e.add(pic.big_pic);
            }
        }
    }

    public CustomMessage<ImageViewerConfig> a(Context context) {
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(this.f62694e);
        bVar.B(this.f62695f);
        bVar.z(this.f62696g);
        bVar.y(this.f62697h);
        bVar.P(this.f62698i);
        bVar.C(true);
        bVar.G(false);
        ArrayList<String> arrayList = this.f62694e;
        bVar.K(arrayList.get(arrayList.size() - 1));
        return new CustomMessage<>(2010000, bVar.v(context));
    }
}
