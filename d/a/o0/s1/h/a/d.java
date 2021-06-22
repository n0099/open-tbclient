package d.a.o0.s1.h.a;

import com.baidu.tieba.memberCenter.tail.data.TailData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTails.ColorInfo;
import tbclient.GetTails.ResData;
import tbclient.GetTails.TailInfo;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<TailData> f64437a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f64438b = new ArrayList();

    public List<String> a() {
        return this.f64438b;
    }

    public List<TailData> b() {
        return this.f64437a;
    }

    public void c(ResData resData) {
        List<TailInfo> list;
        if (resData == null || (list = resData.tailList) == null) {
            return;
        }
        for (TailInfo tailInfo : list) {
            if (e(tailInfo)) {
                TailData tailData = new TailData();
                tailData.setContent(tailInfo.tailContent);
                tailData.setFontColor(tailInfo.fontColor);
                tailData.setFontType(tailInfo.fontKeyName);
                tailData.setId(tailInfo.tailId.intValue());
                tailData.setSelected(tailInfo.is_selected.intValue() == 1);
                b().add(tailData);
            }
        }
        d(resData.default_color);
        for (ColorInfo colorInfo : resData.colorList) {
            a().add(colorInfo.fontColor);
        }
    }

    public void d(String str) {
    }

    public final boolean e(TailInfo tailInfo) {
        Integer num = tailInfo.tailId;
        return (num == null || num.intValue() == 0 || tailInfo.fontColor == null) ? false : true;
    }
}
