package d.a.n0.b1.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements c {
    @Override // d.a.n0.b1.j.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i2, int i3) {
        if (ListUtils.getCount(list) <= 0) {
            return i3;
        }
        if (i2 == 0) {
            return e(constrainImageLayout, list, i3);
        }
        if (i2 == 1) {
            return d(constrainImageLayout, list, i3);
        }
        return i2 == 2 ? c(constrainImageLayout, list, i3) : i3;
    }

    @Override // d.a.n0.b1.j.c
    public int b(int i2) {
        if (i2 < 4) {
            return 1;
        }
        return (i2 < 4 || i2 >= 7) ? 3 : 2;
    }

    public final int c(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i2) {
        if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
            return i2;
        }
        int count = ListUtils.getCount(list);
        constrainImageLayout.setImageMaxChildCount(3);
        int i3 = count - 9;
        if (i3 > 0) {
            int i4 = i2 + 3;
            List<MediaData> subList = ListUtils.subList(list, i2, i4);
            constrainImageLayout.setExtraCenterText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i3)}));
            constrainImageLayout.setUrls(subList, i2, true);
            return i4;
        }
        constrainImageLayout.setUrls(ListUtils.subList(list, i2, count), i2);
        constrainImageLayout.setExtraCenterText(null);
        return count;
    }

    public final int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i2) {
        if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
            return i2;
        }
        if (ListUtils.getCount(list) == 4) {
            int i3 = i2 + 2;
            constrainImageLayout.setUrls(ListUtils.subList(list, i2, i3), i2);
            return i3;
        }
        int i4 = i2 + 3;
        constrainImageLayout.setUrls(ListUtils.subList(list, i2, i4), i2);
        return i4;
    }

    public final int e(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i2) {
        if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
            return i2;
        }
        int count = ListUtils.getCount(list);
        if (count == 1) {
            constrainImageLayout.setUrls(list, i2);
            return 0;
        } else if (count != 2 && count != 4 && count != 5) {
            int i3 = i2 + 3;
            constrainImageLayout.setUrls(ListUtils.subList(list, i2, i3), i2);
            return i3;
        } else {
            int i4 = i2 + 2;
            constrainImageLayout.setUrls(ListUtils.subList(list, i2, i4), i2);
            return i4;
        }
    }
}
