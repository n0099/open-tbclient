package d.a.n0.t3.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import d.a.m0.s.c.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f64907a;

    /* renamed from: e  reason: collision with root package name */
    public String f64911e;

    /* renamed from: f  reason: collision with root package name */
    public int f64912f = -1;

    /* renamed from: b  reason: collision with root package name */
    public final List<VideoItemModel> f64908b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public final int f64909c = e.g() - 1;

    /* renamed from: d  reason: collision with root package name */
    public final int f64910d = e.f() + 1;

    public void a(int i2) {
        VideoItemModel videoItemModel;
        if (VideoMiddleAdSwitch.isOn()) {
            ArrayList arrayList = new ArrayList(this.f64908b);
            int i3 = this.f64912f;
            if (i3 < 0) {
                i3 = this.f64909c;
            }
            this.f64912f = i3;
            while (i3 < arrayList.size() + 1) {
                if (i3 > i2 && ((videoItemModel = (VideoItemModel) ListUtils.getItem(arrayList, i3)) == null || !videoItemModel.isFunAdType())) {
                    this.f64912f = i3;
                    arrayList.add(i3, new VideoItemModel(null, true));
                }
                i3 += this.f64910d;
            }
            this.f64908b.clear();
            this.f64908b.addAll(arrayList);
        }
    }

    public void b(@NonNull List<VideoItemData> list) {
        ArrayList arrayList = new ArrayList();
        for (VideoItemData videoItemData : list) {
            arrayList.add(new VideoItemModel(videoItemData, false));
        }
        this.f64908b.addAll(arrayList);
    }

    public boolean c(int i2) {
        if (i2 < 0) {
            return false;
        }
        VideoItemModel videoItemModel = null;
        Iterator<VideoItemModel> it = this.f64908b.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            VideoItemModel next = it.next();
            if (next.getHashCode() == i2) {
                videoItemModel = next;
                break;
            }
        }
        if (videoItemModel == null || !videoItemModel.isFunAdType()) {
            return false;
        }
        this.f64908b.remove(videoItemModel);
        return true;
    }

    public int d() {
        return this.f64908b.size();
    }

    public VideoItemModel e(int i2) {
        return (VideoItemModel) ListUtils.getItem(this.f64908b, i2);
    }

    public BdUniqueId f() {
        return this.f64907a;
    }

    public String g() {
        return this.f64911e;
    }

    @Nullable
    public VideoItemData h(int i2) {
        VideoItemModel videoItemModel = (VideoItemModel) ListUtils.getItem(this.f64908b, i2);
        if (videoItemModel == null) {
            return null;
        }
        return videoItemModel.getVideoItemData();
    }

    public boolean i() {
        return ListUtils.isEmpty(this.f64908b);
    }

    public boolean j(int i2) {
        int i3 = this.f64909c;
        while (i3 < this.f64908b.size()) {
            if (i3 == i2) {
                return true;
            }
            i3 += this.f64910d;
        }
        return false;
    }

    public void k(List<VideoItemData> list) {
        if (list == null) {
            return;
        }
        List arrayList = new ArrayList(this.f64908b);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                break;
            }
            if (!((VideoItemModel) ListUtils.getItem(arrayList, i2)).isFunAdType()) {
                int i4 = i3 + 1;
                VideoItemData videoItemData = (VideoItemData) ListUtils.getItem(list, i3);
                if (videoItemData == null) {
                    arrayList = arrayList.subList(0, i2);
                    i3 = i4;
                    break;
                }
                arrayList.set(i2, new VideoItemModel(videoItemData, false));
                i3 = i4;
            }
            i2++;
        }
        if (i3 < list.size()) {
            for (VideoItemData videoItemData2 : list.subList(i3, list.size())) {
                arrayList.add(new VideoItemModel(videoItemData2, false));
            }
        }
        this.f64908b.clear();
        this.f64908b.addAll(arrayList);
    }

    public void l(BdUniqueId bdUniqueId) {
        this.f64907a = bdUniqueId;
    }

    public void m(String str) {
        this.f64911e = str;
    }
}
