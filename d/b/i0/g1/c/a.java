package d.b.i0.g1.c;

import com.baidu.tieba.interestlabel.model.LabelRequestEnum;
import d.b.i0.g1.b.b;
import java.util.List;
/* loaded from: classes3.dex */
public interface a {
    void callback(LabelRequestEnum labelRequestEnum, b bVar, int i);

    void getLabel();

    void subLabel(List<Integer> list);
}
