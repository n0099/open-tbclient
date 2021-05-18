package d.a.j0.b1.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class f implements c {

    /* renamed from: b  reason: collision with root package name */
    public int f49056b;

    /* renamed from: c  reason: collision with root package name */
    public double f49057c;

    /* renamed from: a  reason: collision with root package name */
    public int f49055a = 3;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49058d = true;

    public f(int i2) {
        this.f49056b = 3;
        if (i2 > 0) {
            this.f49056b = i2;
        }
    }

    @Override // d.a.j0.b1.j.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i2, int i3) {
        return ListUtils.getCount(list) <= 0 ? i3 : e(constrainImageLayout, list, i3);
    }

    @Override // d.a.j0.b1.j.c
    public int b(int i2) {
        return 1;
    }

    public final double c(int i2) {
        TbadkCoreApplication.getInst();
        if (i2 == 1) {
            return 0.5625d;
        }
        double d2 = this.f49057c;
        if (d2 > 0.0d) {
            return d2;
        }
        return 0.6666666666666666d;
    }

    public void d(double d2) {
        this.f49057c = d2;
    }

    public int e(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i2) {
        int i3;
        if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
            return i2;
        }
        int count = ListUtils.getCount(list);
        if (count >= 2) {
            constrainImageLayout.setImageMaxChildCount(this.f49055a);
            constrainImageLayout.setCanCenterStart(false);
        } else {
            constrainImageLayout.setImageMaxChildCount(-1);
            constrainImageLayout.setCanCenterStart(true);
        }
        int i4 = this.f49056b;
        int i5 = count - i4;
        if (i5 > 0) {
            i3 = i4 + i2;
            List<MediaData> subList = ListUtils.subList(list, i2, i3);
            constrainImageLayout.setExtraCenterText(this.f49058d ? TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i5)}) : null);
            constrainImageLayout.setUrls(subList, i2, true, this.f49058d);
        } else {
            constrainImageLayout.setUrls(ListUtils.subList(list, i2, count), i2);
            constrainImageLayout.setExtraCenterText(null);
            i3 = count;
        }
        constrainImageLayout.setSingleImageRatio(c(count));
        return i3;
    }
}
