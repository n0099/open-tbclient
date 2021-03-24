package d.b.h0.b1.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class f implements c {

    /* renamed from: b  reason: collision with root package name */
    public int f49934b;

    /* renamed from: c  reason: collision with root package name */
    public double f49935c;

    /* renamed from: a  reason: collision with root package name */
    public int f49933a = 3;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49936d = true;

    public f(int i) {
        this.f49934b = 3;
        if (i > 0) {
            this.f49934b = i;
        }
    }

    @Override // d.b.h0.b1.j.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return ListUtils.getCount(list) <= 0 ? i2 : e(constrainImageLayout, list, i2);
    }

    @Override // d.b.h0.b1.j.c
    public int b(int i) {
        return 1;
    }

    public final double c(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        double d2 = this.f49935c;
        if (d2 > 0.0d) {
            return d2;
        }
        return 0.6666666666666666d;
    }

    public void d(double d2) {
        this.f49935c = d2;
    }

    public int e(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
            return i;
        }
        int count = ListUtils.getCount(list);
        if (count >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.f49933a);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = this.f49934b;
        int i4 = count - i3;
        if (i4 > 0) {
            i2 = i3 + i;
            List<MediaData> subList = ListUtils.subList(list, i, i2);
            constrainImageLayout.setExtraCenterText(this.f49936d ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i4)}) : null);
            constrainImageLayout.setUrls(subList, i, true, this.f49936d);
        } else {
            constrainImageLayout.setUrls(ListUtils.subList(list, i, count), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = count;
        }
        constrainImageLayout.setSingleImageRatio(c(count));
        return i2;
    }
}
