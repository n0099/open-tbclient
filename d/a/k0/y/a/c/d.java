package d.a.k0.y.a.c;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.ArrayList;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class d implements d.a.j0.g0.b.a {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f63418e;

    /* renamed from: f  reason: collision with root package name */
    public int f63419f;

    /* renamed from: g  reason: collision with root package name */
    public String f63420g;

    /* renamed from: h  reason: collision with root package name */
    public String f63421h;

    /* renamed from: i  reason: collision with root package name */
    public String f63422i;

    public d(int i2, tinfo tinfoVar) {
        if (tinfoVar == null) {
            return;
        }
        this.f63418e = new ArrayList<>();
        this.f63419f = i2;
        this.f63421h = String.valueOf(tinfoVar.forum_id);
        this.f63420g = tinfoVar.forum_name;
        this.f63422i = String.valueOf(tinfoVar.thread_id);
        for (Pic pic : tinfoVar.pics) {
            if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                this.f63418e.add(pic.big_pic);
            }
        }
    }

    public CustomMessage<ImageViewerConfig> a(Context context) {
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(this.f63418e);
        bVar.B(this.f63419f);
        bVar.z(this.f63420g);
        bVar.y(this.f63421h);
        bVar.O(this.f63422i);
        bVar.C(true);
        bVar.F(false);
        ArrayList<String> arrayList = this.f63418e;
        bVar.J(arrayList.get(arrayList.size() - 1));
        return new CustomMessage<>(2010000, bVar.v(context));
    }
}
