package d.a.n0.a0.a.c;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class d implements d.a.m0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f51134e;

    /* renamed from: f  reason: collision with root package name */
    public int f51135f;

    /* renamed from: g  reason: collision with root package name */
    public String f51136g;

    /* renamed from: h  reason: collision with root package name */
    public String f51137h;

    /* renamed from: i  reason: collision with root package name */
    public String f51138i;

    public d(int i2, tinfo tinfoVar) {
        if (tinfoVar == null) {
            return;
        }
        this.f51134e = new ArrayList<>();
        this.f51135f = i2;
        this.f51137h = String.valueOf(tinfoVar.forum_id);
        this.f51136g = tinfoVar.forum_name;
        this.f51138i = String.valueOf(tinfoVar.thread_id);
        for (Pic pic : tinfoVar.pics) {
            if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                this.f51134e.add(pic.big_pic);
            }
        }
    }

    public CustomMessage<ImageViewerConfig> a(Context context) {
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(this.f51134e);
        bVar.B(this.f51135f);
        bVar.z(this.f51136g);
        bVar.y(this.f51137h);
        bVar.O(this.f51138i);
        bVar.C(true);
        bVar.F(false);
        ArrayList<String> arrayList = this.f51134e;
        bVar.J(arrayList.get(arrayList.size() - 1));
        return new CustomMessage<>(2010000, bVar.v(context));
    }
}
