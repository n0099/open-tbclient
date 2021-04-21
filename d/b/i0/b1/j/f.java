package d.b.i0.b1.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class f implements c {

    /* renamed from: b  reason: collision with root package name */
    public int f50664b;

    /* renamed from: c  reason: collision with root package name */
    public double f50665c;

    /* renamed from: a  reason: collision with root package name */
    public int f50663a = 3;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50666d = true;

    public f(int i) {
        this.f50664b = 3;
        if (i > 0) {
            this.f50664b = i;
        }
    }

    @Override // d.b.i0.b1.j.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        return ListUtils.getCount(list) <= 0 ? i2 : e(constrainImageLayout, list, i2);
    }

    @Override // d.b.i0.b1.j.c
    public int b(int i) {
        return 1;
    }

    public final double c(int i) {
        TbadkCoreApplication.getInst();
        if (i == 1) {
            return 0.5625d;
        }
        double d2 = this.f50665c;
        if (d2 > 0.0d) {
            return d2;
        }
        return 0.6666666666666666d;
    }

    public void d(double d2) {
        this.f50665c = d2;
    }

    public int e(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        int i2;
        if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
            return i;
        }
        int count = ListUtils.getCount(list);
        if (count >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.f50663a);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i3 = this.f50664b;
        int i4 = count - i3;
        if (i4 > 0) {
            i2 = i3 + i;
            List<MediaData> subList = ListUtils.subList(list, i, i2);
            constrainImageLayout.setExtraCenterText(this.f50666d ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i4)}) : null);
            constrainImageLayout.setUrls(subList, i, true, this.f50666d);
        } else {
            constrainImageLayout.setUrls(ListUtils.subList(list, i, count), i);
            constrainImageLayout.setExtraCenterText(null);
            i2 = count;
        }
        constrainImageLayout.setSingleImageRatio(c(count));
        return i2;
    }
}
