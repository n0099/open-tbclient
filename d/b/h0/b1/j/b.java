package d.b.h0.b1.j;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements c {
    @Override // d.b.h0.b1.j.c
    public int a(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i, int i2) {
        if (ListUtils.getCount(list) <= 0) {
            return i2;
        }
        if (i == 0) {
            return e(constrainImageLayout, list, i2);
        }
        if (i == 1) {
            return d(constrainImageLayout, list, i2);
        }
        return i == 2 ? c(constrainImageLayout, list, i2) : i2;
    }

    @Override // d.b.h0.b1.j.c
    public int b(int i) {
        if (i < 4) {
            return 1;
        }
        return (i < 4 || i >= 7) ? 3 : 2;
    }

    public final int c(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
            return i;
        }
        int count = ListUtils.getCount(list);
        constrainImageLayout.setImageMaxChildCount(3);
        int i2 = count - 9;
        if (i2 > 0) {
            int i3 = i + 3;
            List<MediaData> subList = ListUtils.subList(list, i, i3);
            constrainImageLayout.setExtraCenterText(TbadkCoreApplication.getInst().getString(R.string.constrain_image_extra_text, new Object[]{Integer.valueOf(i2)}));
            constrainImageLayout.setUrls(subList, i, true);
            return i3;
        }
        constrainImageLayout.setUrls(ListUtils.subList(list, i, count), i);
        constrainImageLayout.setExtraCenterText(null);
        return count;
    }

    public final int d(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
            return i;
        }
        if (ListUtils.getCount(list) == 4) {
            int i2 = i + 2;
            constrainImageLayout.setUrls(ListUtils.subList(list, i, i2), i);
            return i2;
        }
        int i3 = i + 3;
        constrainImageLayout.setUrls(ListUtils.subList(list, i, i3), i);
        return i3;
    }

    public final int e(ConstrainImageLayout constrainImageLayout, List<MediaData> list, int i) {
        if (constrainImageLayout == null || ListUtils.isEmpty(list)) {
            return i;
        }
        int count = ListUtils.getCount(list);
        if (count == 1) {
            constrainImageLayout.setUrls(list, i);
            return 0;
        } else if (count != 2 && count != 4 && count != 5) {
            int i2 = i + 3;
            constrainImageLayout.setUrls(ListUtils.subList(list, i, i2), i);
            return i2;
        } else {
            int i3 = i + 2;
            constrainImageLayout.setUrls(ListUtils.subList(list, i, i3), i);
            return i3;
        }
    }
}
